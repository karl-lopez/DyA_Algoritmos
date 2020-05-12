package DAAlgoritmos;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


//import pruebas.Grafos;



	public class Grafos {

		//Generador de Nodos
		public static HashMap<String,Integer> nodo(int n){
			HashMap <String,Integer> num_nod = new HashMap <String, Integer>();
			int fin = n; 
			for (int i=0;i< fin; i++) {
				if(num_nod.containsKey("Nodo"+i)) {}
				else {
					num_nod.put("Nodo"+i, i);
				}
			}
			return num_nod;
		}
		
		//Generador de numeros aleatorios (Geografico)
		public static HashMap<Integer,Double> Esp(int n){
			HashMap <Integer,Double> Esp_x= new HashMap<Integer,Double>();
			int fin = n;
			for (int i=0;i<fin;i++) {
				if(Esp_x.containsKey(i)) {}
				else {
					Esp_x.put(i,Math.random());
				}
			}
			return Esp_x; 
		}
		
		//Generador de grafos Ergos
		public static HashMap<String,Integer> G_ER(Integer n, Integer m,Boolean dig, Boolean auto){
			HashMap <String,Integer> M_ER = new HashMap <String,Integer>();
			HashMap <String,Integer> Nodos = new HashMap <String,Integer>();
			int fin = m;
			int N1; int N2;
			Nodos = nodo(n);
			int To_nod= Nodos.size();
			Boolean dir= dig;
			Boolean Auto_d=auto;
			for(int i=0;i<fin;i++) {
				double V1=(To_nod-1)*Math.random();
				double V2=(To_nod-1)*Math.random();
				N1= (int)V1;
				N2= (int)V2;
				if (dir == true) {
					if(Auto_d == true) {
						if(M_ER.containsKey("Nodo"+N1+"->"+"Nodo"+N2)) {
							i=i-1;
						}else {
							M_ER.put("Nodo"+N1+"->"+"Nodo"+N2, i);
						}
						}else {
							if(M_ER.containsKey("Nodo"+N1+"->"+"Nodo"+N2) || N1==N2) {
								i=i-1;
							}else {
								M_ER.put("Nodo"+N1+"->"+"Nodo"+N2, i);
							}	
						}
				}else {
					if(Auto_d == true) {
						if(M_ER.containsKey("Nodo"+N1+"--Nodo"+N2) || M_ER.containsKey("Nodo"+N2+"--Nodo"+N1)) {
							i=i-1;
					}else {
						M_ER.put("Nodo"+N1+"--Nodo"+N2, i);
					}
					}else {
						if(M_ER.containsKey("Nodo"+N1+"--Nodo"+N2) || M_ER.containsKey("Nodo"+N2+"--Nodo"+N1) || N1==N2) {
							i=i-1;
						}else {
							M_ER.put("Nodo"+N1+"--Nodo"+N2, i);
						}	
					}				
				}
			}
		return M_ER;	
		}
		
		//Generador de grafos Gilbert
		public static HashMap<String,Integer> G_Gil(Integer n, Double p,Boolean dig, Boolean auto){
			HashMap <String,Integer> M_Gil = new HashMap <String,Integer>();
			HashMap <String,Integer> Nodos = new HashMap <String,Integer>();
			//double Prob=p;
			Nodos = nodo(n);
			int To_nod= Nodos.size();
			Boolean dir= dig;
			Boolean Auto_d=auto;
			int Arista=0;
			for(int i=0;i<To_nod;i++) {
				for(int j=0;j<To_nod;j++) {
					double V1=Math.random();
					if(V1<=p) {
					if (dir == true) {
						if(Auto_d == true) {
								M_Gil.put("Nodo"+i+"->"+"Nodo"+j, Arista);
								Arista = Arista+1;
							}else if(i!=j) {							
								M_Gil.put("Nodo"+i+"->"+"Nodo"+j, Arista);
								Arista = Arista+1;
								}	
							}else {
						if(Auto_d == true) {
							if(M_Gil.containsKey("Nodo"+j+"--Nodo"+i)) {
						}else {
							M_Gil.put("Nodo"+i+"--Nodo"+j, Arista);
							Arista=Arista+1;
						}
						}else {
							if(M_Gil.containsKey("Nodo"+j+"--Nodo"+i) || i==j) {
							}else {
								M_Gil.put("Nodo"+i+"--Nodo"+j, Arista);
								Arista = Arista +1;
							}	
						}				
					}	
				}
			}
			}
		return M_Gil;	
		}
		
		//Generador de grafos Geografico
		public static HashMap<String,Integer> G_Geo(Integer n, Double r,Boolean dig, Boolean auto){
			HashMap <String,Integer> M_Geo = new HashMap <String,Integer>();
			HashMap <Integer,Double> Nodos_x = new HashMap <Integer,Double>();
			HashMap <Integer,Double> Nodos_y = new HashMap <Integer,Double>();
			//int N1; int N2;
			//double =p;
			Nodos_x = Esp(n);
			Nodos_y = Esp(n);
			//int To_nod= Nodos.size();
			Boolean dir= dig;
			Boolean Auto_d=auto;
			int Arista=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					double V1=Math.sqrt((Math.pow((Nodos_x.get(j)-Nodos_x.get(i)), 2))+ (Math.pow((Nodos_y.get(j)-Nodos_y.get(i)), 2)));
					if(V1<=r) {
					if (dir == true) {
						if(Auto_d == true) {
								M_Geo.put("Nodo"+i+"->"+"Nodo"+j, Arista);
								Arista = Arista+1;
							}else if(i!=j) {							
								M_Geo.put("Nodo"+i+"->"+"Nodo"+j, Arista);
								Arista = Arista+1;
								}	
							}else {
						if(Auto_d == true) {
							if(M_Geo.containsKey("Nodo"+j+"--Nodo"+i)) {
						}else {
							M_Geo.put("Nodo"+i+"--Nodo"+j, Arista);
							Arista=Arista+1;
						}
						}else {
							if(M_Geo.containsKey("Nodo"+j+"--Nodo"+i) || i==j) {
							}else {
								M_Geo.put("Nodo"+i+"--Nodo"+j, Arista);
								Arista = Arista +1;
							}	
						}				
					}	
				}
			}
			}
		return M_Geo;	
		}
		
		//Generador de grafos Barabasi
		public static HashMap<String,Integer> G_Bar(Integer n, Integer d,Boolean dig, Boolean auto){
			HashMap <String,Integer> M_Bar = new HashMap <String,Integer>();
			HashMap <String,Integer> Nodos = new HashMap <String,Integer>();
			HashMap <Integer,Integer> Grado_ini = new HashMap <Integer,Integer>();
			HashMap <Integer,Integer> Grado_fin = new HashMap <Integer,Integer>();
			//int N1; int N2;
			//double =p;
			Nodos = nodo(n);
			//Grado.put(0, 0);
			//int To_nod= Nodos.size();
			Boolean dir= dig;
			Boolean Auto_d=auto;
			int Arista=0;
			int N_ini=0;
					if (dir == true) {
						if(Auto_d == true) {
							for(int i=0;i<n;i++) {
								for(int j=0;j<=i;j++) {
									double Prob1 =Math.random();
									double Prob2 =Math.random();
									if (Grado_ini.containsKey(j) == false){
										Grado_ini.put(j,0);
									}
									if (Grado_ini.containsKey(i) == false){
										Grado_ini.put(i,0);
									}
									if (Grado_ini.get(j) < d){
										double P1= 1 - (Grado_ini.get(i)/d);
										double P2= 1 - (Grado_ini.get(j)/d);
										if (i!=j) {
											if(Prob1<=P1) {
											M_Bar.put("Nodo"+i+"->"+"Nodo"+j, Arista);
											Arista = Arista + 1;
											N_ini=Grado_ini.get(i)+1;
											Grado_fin.put(i, N_ini);
										}	if(Prob2<=P2) {
											M_Bar.put("Nodo"+j+"->"+"Nodo"+i, Arista);
											Arista = Arista + 1;
											N_ini = Grado_ini.get(j)+1;
											Grado_fin.put(j, N_ini);
										}		
									} else if(Prob1<=P1) {
										M_Bar.put("Nodo"+i+"->"+"Nodo"+j, Arista);
										Arista = Arista + 1;
										N_ini=Grado_ini.get(j)+1;
										//Grado_fin.put(i, Grado_ini.get(i)+1);
										Grado_fin.put(j, Grado_ini.get(j)+1);
										}}}
								Grado_ini = Grado_fin;
								}} else {
										for(int i=0;i<n;i++) {
											for(int j=0;j<=i;j++) {
												double Prob1 =Math.random();
												double Prob2 =Math.random();
												if (Grado_ini.containsKey(j) == false){
													Grado_ini.put(j,0);
												}
												if (Grado_ini.containsKey(i) == false){
													Grado_ini.put(i,0);
												}
												if (Grado_ini.get(j) < d && i!=j){
													double P1= 1 - (Grado_ini.get(i)/d);
													double P2= 1 - (Grado_ini.get(j)/d);
													if(Prob1<=P1) {
														M_Bar.put("Nodo"+i+"->Nodo"+j, Arista);
														Arista = Arista + 1;
														N_ini=Grado_ini.get(i)+1;
														Grado_fin.put(i, N_ini);
													} if(Prob2<=P2) {
														M_Bar.put("Nodo"+j+"->"+"Nodo"+i, Arista);
														Arista = Arista + 1;
														N_ini=Grado_ini.get(j)+1;
														Grado_fin.put(j, N_ini);
													}
												}
												Grado_ini = Grado_fin;
												}}}
									}else if(Auto_d == true) {
										for(int i=0;i<n;i++) {
											for(int j=0;j<=i;j++) {
												double Prob =Math.random();
												if (Grado_ini.containsKey(j) == false){
													Grado_ini.put(j,0);
												}
												if (Grado_ini.containsKey(i) == false){
													Grado_ini.put(i,0);
												}
												if (Grado_ini.get(j) < d){
													double P= 1 - (Grado_ini.get(j)/d);
													if(Prob<=P) {
														M_Bar.put("Nodo"+i+"--Nodo"+j, Arista);
														Arista = Arista + 1;
														Grado_fin.put(i, Grado_ini.get(i)+1);
														Grado_fin.put(j, Grado_ini.get(j)+1);
													}}}
											Grado_ini = Grado_fin;
											}} else {
												for(int i=0;i<n;i++) {
													for(int j=0;j<=i;j++) {
														double Prob =Math.random();
														if (Grado_ini.containsKey(j) == false){
															Grado_ini.put(j,0);
														}
														if (Grado_ini.containsKey(i) == false){
															Grado_ini.put(i,0);
														}
														if (Grado_ini.get(j) < d && i!=j){
															double P= 1 - (Grado_ini.get(j)/d);
															if(Prob<=P) {
																M_Bar.put("Nodo"+i+"--Nodo"+j, Arista);
																Arista = Arista + 1;
																Grado_fin.put(i, Grado_ini.get(i)+1);
																Grado_fin.put(j, Grado_ini.get(j)+1);
															}}}
													Grado_ini = Grado_fin;
													}}
		return M_Bar;	
		}
		
		//Exportar en Archivo dot o csv las aristas
		public static void Aristas(HashMap <String,Integer> Mod) throws IOException {
			HashMap <String,Integer> Arista = new HashMap <String,Integer> ();
			Scanner f = new Scanner(System.in);
			System.out.println("Tipo de Archivo:");
			System.out.println("1. Archivo extensión dot");
			System.out.println("2. Archivo extensión csv");
			int arc= f.nextInt();
			Arista = Mod;
			int fin = Arista.size();
			switch(arc) {
			case 1:
				System.out.println("Nombre del Archivo");
				String  nom = f.next();
				nom = nom + ".dot";
				File Arcf = new File(nom);
				BufferedWriter bf = null;;
				if (Arcf.createNewFile()) {
				try {
					bf = new BufferedWriter(new FileWriter(Arcf));
					bf.write("Source--Target");
					bf.newLine();
					String AW;
					Iterator<String> AF = Arista.keySet().iterator();
					while (AF.hasNext()) {
						AW= AF.next();
						bf.write(AW);
						bf.newLine();
					}
				}catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            
		            try{
		                bf.close();
		            }catch(Exception e){}
				}}
				System.out.println("Listo se ha creado el archivo "+ nom);
				System.out.println("En la ruta "+ Arcf.getAbsolutePath());
				break;
			case 2:
				System.out.println("Nombre del Archivo");
				nom = f.next();
				nom = nom + ".csv";
				Arcf = new File(nom);
				bf = null;;
				if (Arcf.createNewFile()) {
				try {
					bf = new BufferedWriter(new FileWriter(Arcf));
					bf.write("Source,--,Target");
					bf.newLine();
					String AW;
					Iterator<String> AF = Arista.keySet().iterator();
					while (AF.hasNext()) {
						AW= new String(AF.next());
						AW=AW.replace("--", ",--,");
						AW=AW.replace("->", ",->,");
						bf.write(AW);
						bf.newLine();
					}
				}catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            
		            try{
		                bf.close();
		            }catch(Exception e){}
				}} System.out.println("Listo se ha creado el archivo "+ nom);
				System.out.println("En la ruta "+ Arcf.getAbsolutePath());
				break;
			}
			
		//return Arcf;	
		}
		
		//Crea el archivo con pesos 
		public static void Aristas_p(HashMap <String,Double> Mod) throws IOException {
			HashMap <String,Double> Arista = new HashMap <String,Double> ();
			Scanner f = new Scanner(System.in);
			System.out.println("Tipo de Archivo:");
			System.out.println("1. Archivo extensión dot");
			System.out.println("2. Archivo extensión csv");
			int arc= f.nextInt();
			Arista = Mod;
			int fin = Arista.size();
			switch(arc) {
			case 1:
				System.out.println("Nombre del Archivo");
				String  nom = f.next();
				nom = nom + ".dot";
				File Arcf = new File(nom);
				BufferedWriter bf = null;;
				if (Arcf.createNewFile()) {
				try {
					bf = new BufferedWriter(new FileWriter(Arcf));
					bf.write("Source--Target--Weight");
					bf.newLine();
					String AW;
					Iterator<String> AF = Arista.keySet().iterator();
					while (AF.hasNext()) {
						AW= AF.next();
						AW= AW+"--"+Arista.get(AW);
						bf.write(AW);
						bf.newLine();
					}
				}catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            
		            try{
		                bf.close();
		            }catch(Exception e){}
				}}
				System.out.println("Listo se ha creado el archivo "+ nom);
				System.out.println("En la ruta "+ Arcf.getAbsolutePath());
				break;
			case 2:
				System.out.println("Nombre del Archivo");
				nom = f.next();
				nom = nom + ".csv";
				Arcf = new File(nom);
				bf = null;;
				if (Arcf.createNewFile()) {
				try {
					bf = new BufferedWriter(new FileWriter(Arcf));
					bf.write("Source,--,Target,Weight");
					bf.newLine();
					String AW;
					Iterator<String> AF = Arista.keySet().iterator();
					while (AF.hasNext()) {
						AW= new String(AF.next());
						AW=AW+","+Arista.get(AW);
						AW=AW.replace("--", ",--,");
						AW=AW.replace("->", ",->,");
						bf.write(AW);
						bf.newLine();
					}
				}catch(IOException e){
		            e.printStackTrace();
		        }finally{
		            
		            try{
		                bf.close();
		            }catch(Exception e){}
				}} System.out.println("Listo se ha creado el archivo "+ nom);
				System.out.println("En la ruta "+ Arcf.getAbsolutePath());
				break;
			}
			
		//return Arcf;	
		}
		
		//Extracción de Nodos con base en las aristas
		public static  HashMap<Integer,String> ext( HashMap<String,Integer> a){
			HashMap<String,Integer> aristas = new HashMap<String,Integer> ();
			HashMap<String,String> nodo = new HashMap<String,String> ();
			HashMap<Integer,String> nodo_f = new HashMap<Integer,String> ();
			aristas= a;
			Iterator<String> ar = aristas.keySet().iterator();
			while(ar.hasNext()){
		        String clave = ar.next();
		        int n= clave.indexOf("-");
		        String x = clave.substring(0, n);
		        String y = clave.substring(n+2, clave.length());
		        nodo.put(x,x);
		        nodo.put(y,y);	
			}
		    Iterator<String> ar1=nodo.keySet().iterator();
		    int b=0;
		    while (ar1.hasNext()) {
		    	String d =ar1.next();
		    	nodo_f.put(b,d);
		    	b=b+1;
		    }
		return nodo_f;	
		}
		
		//Validación de Nodo seleccionado
		public static boolean val_nodo(HashMap<Integer,String> node,String n) {
			String nod1 = new String(n);
			HashMap<Integer,String> nodos = new HashMap<Integer,String>();
			nodos= node;
			boolean valida = false;
			int base;
			Iterator<Integer> clave = nodos.keySet().iterator();
			while (clave.hasNext() & valida == false) {
				base = clave.next();
				String nod2= new String (nodos.get(base));
				if(nod1.equalsIgnoreCase(nod2)) {
					valida = true;
				}
			}
			return valida;
		}
		
		//Algoritmo BFS
		public static HashMap<String,Integer> bfs (String nodo, HashMap<String,Integer> a,boolean dig){
			Grafos g = new Grafos();
			HashMap<Integer,String> nvo_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> exp_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> vis_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> lim_aristas = new HashMap<Integer,String> ();
			HashMap<String,Integer> vis_arista = new HashMap<String,Integer> ();
			HashMap<String,Integer> aristas = new HashMap<String,Integer> ();
			nvo_nodos= g.ext(a);
			aristas = a;
			int inicio_vis =0;
			int fin_exp =0;
			int inicio_arb=0;
			int li =0;
			String ady=null;
			exp_nodos.put(inicio_vis,nodo);
			if (dig == true) {
				// Grafo dirigido
			while (nvo_nodos.size() != vis_nodos.size() & aristas.isEmpty() == false ) {
					Iterator <String> ar1 = aristas.keySet().iterator();
					if (exp_nodos.containsKey(inicio_vis)) {
						nodo=exp_nodos.get(inicio_vis);
					} else {
						int st= 0;
						while (exp_nodos.containsValue(nvo_nodos.get(st))) {
							st=st+1;
						}
						nodo=nvo_nodos.get(st);
						fin_exp= fin_exp + 1;
						exp_nodos.put(fin_exp, nodo);
					}
					while (ar1.hasNext()) {
						ady=ar1.next();
						String nod=ady.substring(ady.indexOf("-")+2,ady.length());
						if((ady.indexOf(nodo) == 0) & (nodo != nod)) {
							if (exp_nodos.containsValue(nod) == false) {
							vis_arista.put(ady.replace("->", "--"),inicio_arb);
							inicio_arb=inicio_arb+1;
								fin_exp= fin_exp + 1;
								exp_nodos.put(fin_exp,nod);	
							}
							lim_aristas.put(li,ady);
							li=li+1;
						}					
					} 
					for (int t=0;t<lim_aristas.size();t++) {
						aristas.remove(lim_aristas.get(t));
					}
					lim_aristas.clear();
					li=0;
					vis_nodos.put(inicio_vis,nodo);
					inicio_vis = inicio_vis+1;
					}}
			// No dirigido 
					else {
						while (nvo_nodos.size() != vis_nodos.size() & aristas.isEmpty() == false ) {
							if (exp_nodos.containsKey(inicio_vis)) {
								nodo=exp_nodos.get(inicio_vis);
							} else {
								int st= 0;
								while (exp_nodos.containsValue(nvo_nodos.get(st))) {
									st=st+1;
								}
								nodo=nvo_nodos.get(st);
								fin_exp= fin_exp + 1;
								exp_nodos.put(fin_exp, nodo);
							}
							Iterator <String> ar1 = aristas.keySet().iterator();
							while (ar1.hasNext()) {
								ady=ar1.next();
								String nod=ady.substring(0,ady.indexOf("-"));
								String nod2=ady.substring(ady.indexOf("-")+2,ady.length());
								if((nodo.equalsIgnoreCase(nod)) & (nodo.equalsIgnoreCase(nod2) == false)) {
									if (exp_nodos.containsValue(nod2) == false) {
										vis_arista.put( ady,inicio_arb);
										inicio_arb=inicio_arb+1;
										fin_exp= fin_exp + 1;
										exp_nodos.put(fin_exp,nod2);	
									}
									lim_aristas.put(li,ady);
									li=li+1;
								}else if((nodo.equalsIgnoreCase(nod) == false) & (nodo.equalsIgnoreCase(nod2))) {
									if (exp_nodos.containsValue(nod) == false) {
										vis_arista.put(nod2+"--"+nod,inicio_arb);
										inicio_arb=inicio_arb+1;
										fin_exp= fin_exp + 1;
										exp_nodos.put(fin_exp,nod);	
									}
									lim_aristas.put(li,ady);
									li=li+1;
								}
							} 
							for (int t=0;t<lim_aristas.size();t++) {
								aristas.remove(lim_aristas.get(t));
							}
							lim_aristas.clear();
							vis_nodos.put(inicio_vis,nodo);
							inicio_vis = inicio_vis+1;
							}
					}
			vis_arista= g.Tot_ari(nvo_nodos, vis_arista);
			return vis_arista;
		}
		
		//Selección del Nodo origen
		//Código para solicitar el nodo a buscar.
		public static String Nodo_arb (HashMap<String,Integer> Ari,int ori) {
			Grafos g = new Grafos();
			HashMap<Integer,String> nvo_nodos = new HashMap<Integer,String> ();
			HashMap<String,Integer> aristas = new HashMap<String,Integer> ();
			Scanner datos = new Scanner(System.in);
			nvo_nodos= g.ext(Ari);
			aristas = Ari;
			String nodo = null;
			int res = 0;
			// Validación del nodo solicitado
			switch (ori) {
			case 0:
				System.out.println("¿Desea inserta el nodo? S/N");
				break;
			case 1:
				System.out.println("¿Desea inserta el nodo origen? S/N");
				break;
			case 2:
				System.out.println("¿Desea inserta el nodo destino? S/N");
				break;
			}
				String opc = datos.next();
				switch (opc.toUpperCase()) {
				case "S":
				int pr = 0;
					while ( pr != 2) {
					switch (pr) {
					case 0:
						System.out.println("Inserte el nodo \" Ej."+ nvo_nodos.get(0)+"\":");
						nodo = datos.next();
						break;
					case 1:
						System.out.println("Nodo Incorrecto, favor de inserta otro nodo");
						nodo = datos.next();
						System.out.println(nodo+" P2");
						break;
					}
					boolean valida = g.val_nodo(nvo_nodos, nodo);
					//System.out.println(valida+" P3");
					if (valida == true) {
						pr=2;}
					else{pr=1;}}
					break;
				case "N":
					double V1=(nvo_nodos.size()-1)*Math.random();
					int N1= (int)V1;
					nodo = nvo_nodos.get(N1);
					break;
				default:
					System.out.println("Opción invalida");
					break;
				}
			return nodo;
		}
		
		//Insertar al arbol generado los nodos que no se encuentren.
		public static HashMap<String,Integer> Tot_ari(HashMap<Integer,String> nodo,HashMap<String,Integer> arb){
			Grafos g = new Grafos();
			HashMap<Integer,String> nvo_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> vis_nodos = new HashMap<Integer,String> ();
			HashMap<String,Integer> vis_arista = new HashMap<String,Integer> ();
			nvo_nodos =nodo;
			vis_nodos = g.ext(arb);
			vis_arista= arb;
			if (vis_arista.size() != nvo_nodos.size()) {
			int fin = Math.max(nvo_nodos.size(), vis_nodos.size());
			for (int i = 0;i<fin;i++) {
				if (vis_nodos.containsValue(nvo_nodos.get(i))==false){
					vis_arista.put(nvo_nodos.get(i)+"--"+nvo_nodos.get(i), vis_arista.size());
				}
			}}
		return vis_arista;
		}
		
		//DFS Iterativo. 
		public static HashMap<String,Integer> dfs_ite (String nodo, HashMap<String,Integer> a,boolean dig){
			Grafos g = new Grafos();
			HashMap<Integer,String> nvo_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> exp_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> vis_nodos = new HashMap<Integer,String> ();
			HashMap<Integer,String> lim_aristas = new HashMap<Integer,String> ();
			HashMap<String,Integer> vis_arista = new HashMap<String,Integer> ();
			HashMap<String,Integer> aristas = new HashMap<String,Integer> ();
			Scanner datos = new Scanner(System.in);
			nvo_nodos= g.ext(a);
			aristas = a;
			int inicio_vis =0;
			int fin_exp =0;
			int inicio_arb=0;
			int li =0;
			String ady=null;
			exp_nodos.put(inicio_vis,nodo);
			if (dig == true) {
				// Grafo dirigido
			while (nvo_nodos.size() != vis_nodos.size() /*& aristas.isEmpty() == false*/ ) {
					Iterator <String> ar1 = aristas.keySet().iterator();
					int fin_vis=exp_nodos.size() - 1;
					int i;
						for ( i= fin_vis ;i>-1;i--){
						if (exp_nodos.containsKey(i) & vis_nodos.containsValue(exp_nodos.get(i)) == false) {
								nodo=exp_nodos.get(i);
								i=-2;
							}}
						if (i==-1) {
						int st= 0;
						while (exp_nodos.containsValue(nvo_nodos.get(st))) {
							st=st+1;
						}
						nodo=nvo_nodos.get(st);
						fin_exp= fin_exp + 1;
						exp_nodos.put(fin_exp, nodo);
					}
					boolean sal_fin = false;
					while ((ar1.hasNext()) & (sal_fin == false)) {
						ady=ar1.next();
						String nod=ady.substring(ady.indexOf("-")+2,ady.length());
						if((ady.indexOf(nodo) == 0) & (nodo != nod)) {
							if (exp_nodos.containsValue(nod) == false) {
								vis_arista.put(ady.replace("->", "--"),inicio_arb);
								inicio_arb=inicio_arb+1;
								fin_exp= fin_exp + 1;
								exp_nodos.put(fin_exp,nod);	
								sal_fin = true;
							}
						}					
					} 
					if (sal_fin == false) {
						vis_nodos.put(inicio_vis,nodo);
						inicio_vis = inicio_vis+1;
					}}}
			// No dirigido 
					else {
						while (nvo_nodos.size() != vis_nodos.size() & aristas.isEmpty() == false ) {
							int fin_vis=exp_nodos.size() - 1;
							int i;
								for ( i= fin_vis ;i>-1;i--){
								if (exp_nodos.containsKey(i) & vis_nodos.containsValue(exp_nodos.get(i)) == false) {
										nodo=exp_nodos.get(i);
										i=-2;
									}}
								if (i==-1) {
								int st= 0;
								while (exp_nodos.containsValue(nvo_nodos.get(st))) {
									st=st+1;
								}
								nodo=nvo_nodos.get(st);
								fin_exp= fin_exp + 1;
								exp_nodos.put(fin_exp, nodo);
							}
							boolean sal_fin = false;
							Iterator <String> ar1 = aristas.keySet().iterator();
							while ((ar1.hasNext() & (sal_fin == false)) ) {
								ady=ar1.next();
								String nod=ady.substring(0,ady.indexOf("-"));
								String nod2=ady.substring(ady.indexOf("-")+2,ady.length());
								if((nodo.equalsIgnoreCase(nod)) & (nodo.equalsIgnoreCase(nod2) == false)) {
									if (exp_nodos.containsValue(nod2) == false) {
										vis_arista.put( ady,inicio_arb);
										inicio_arb=inicio_arb+1;
										fin_exp= fin_exp + 1;
										exp_nodos.put(fin_exp,nod2);
										sal_fin=true;
									}
									lim_aristas.put(li,ady);
									li=li+1;
								}else if((nodo.equalsIgnoreCase(nod) == false) & (nodo.equalsIgnoreCase(nod2))) {
									if (exp_nodos.containsValue(nod) == false) {
										vis_arista.put(nod2+"--"+nod,inicio_arb);
										inicio_arb=inicio_arb+1;
										fin_exp= fin_exp + 1;
										exp_nodos.put(fin_exp,nod);
										sal_fin=true;
									}
									lim_aristas.put(li,ady);
									li=li+1;
								}
							} 
							for (int t=0;t<lim_aristas.size();t++) {
								aristas.remove(lim_aristas.get(t));
							}
							lim_aristas.clear();
							li=0;
							if (sal_fin == false) {
								vis_nodos.put(inicio_vis,nodo);
								inicio_vis = inicio_vis+1;							
							}}}
			vis_arista= g.Tot_ari(nvo_nodos, vis_arista);
			return vis_arista;
		}
		
		public static HashMap<String, Integer> rec_dir(String Nodo, HashMap<String,Integer> Arista, HashMap<Integer,String> Visit, HashMap <String,Integer> Arbol){
			Grafos g = new Grafos();
			String nod = null;
			Iterator <String> llave = Arista.keySet().iterator();
			while (llave.hasNext()) {
				String ari = llave.next();
				if (ari.indexOf(Nodo) == 0 ) {
					nod = ari.substring(ari.indexOf("-") + 2, ari.length());
					if (Visit.containsValue(nod) == false) {
						Visit.put(Visit.size(),nod);
						Arbol.put(ari.replace(">", "-"), Arbol.size());
						Arbol = g.rec_dir(nod,Arista,Visit,Arbol);
						Visit = g.ext(Arbol);
					}}
				}
			return Arbol;
		}

		public static HashMap<String, Integer> rec_no_dir(String Nodo, HashMap<String,Integer> Arista, HashMap<Integer,String> Visit, HashMap <String,Integer> Arbol){
			Grafos g = new Grafos();
			String nod2 = null;
			String nod1 = null;
			Iterator <String> llave = Arista.keySet().iterator();
			while (llave.hasNext()) {
				String ari = llave.next();
				if (ari.contains(Nodo)) {
					nod1 = ari.substring(0, ari.indexOf("-"));
					nod2 = ari.substring(ari.indexOf("-") + 2, ari.length());
					if (Visit.containsValue(nod1) == false & Nodo.equalsIgnoreCase(nod2)) {
						Visit.put(Visit.size(),nod1);
						Arbol.put(nod2+"--"+nod1, Arbol.size());
						Arbol = g.rec_no_dir(nod1,Arista,Visit,Arbol);
						Visit = g.ext(Arbol);
					}else if (!Visit.containsValue(nod2) & Nodo.equalsIgnoreCase(nod1)) {
						Visit.put(Visit.size(),nod2);
						Arbol.put(ari, Arbol.size());
						Arbol = g.rec_no_dir(nod2,Arista,Visit,Arbol);
						Visit = g.ext(Arbol);
						}}
					}
			return Arbol;
		}
		
		public static HashMap<String,Integer> dfs_rec(String Nodo, HashMap<String,Integer> Arista,HashMap<String,Integer> Arbol, boolean Dir){
		Grafos g = new Grafos();
		HashMap<Integer,String> Visit = new HashMap<Integer,String>();
		HashMap<Integer,String> Nodos = new HashMap<Integer,String>();
		HashMap<Integer,String> Arb_ari = new HashMap<Integer,String>();
		Nodos = g.ext(Arista);
		Visit = g.ext(Arbol);
			if (Nodos.size() != Visit.size() ) {
				if (Dir == true) {
					Visit.put(Visit.size(), Nodo);
					Arbol = g.rec_dir(Nodo, Arista, Visit, Arbol);
				}else if (Dir==false) {
					Visit.put(Visit.size(), Nodo);
					Arbol = g.rec_no_dir(Nodo, Arista, Visit, Arbol);
				}
			}
		Visit = g.ext(Arbol);
		if(Dir==true) {
			for (int i =0;i<Nodos.size();i++) {
				if(!Visit.containsValue(Nodos.get(i))) {
					Nodo= Nodos.get(i);
					Visit.put(Visit.size(), Nodo);
					Arbol = g.rec_dir(Nodo, Arista, Visit, Arbol);
				}
			}
		}else if (Dir==false) {
			for (int i =0;i<Nodos.size();i++) {
				if(!Visit.containsValue(Nodos.get(i))) {
					Nodo= Nodos.get(i);
					Visit.put(Visit.size(), Nodo);
					Arbol = g.rec_no_dir(Nodo, Arista, Visit, Arbol);
				}
			}		
		}
		Arbol= g.Tot_ari(Nodos, Arbol);
		return Arbol;
		}
		
		//} 
		
		//Crea el peso de las aristas 
		public static HashMap<String, Double> Aristas_pesos(HashMap<String,Integer> Arista,double a, double b,boolean ent){
			HashMap<String,Double> Ari_peso = new HashMap<String,Double>();
			double min = Math.min(a, b);
			double max = Math.max(a, b);
			double rgo = max-min;
			double peso = 0;
			String llave;
			Iterator <String> clave = Arista.keySet().iterator();
			if (ent == false) {
				while(clave.hasNext()){
					llave = clave.next();
					peso = (rgo * Math.random())+min;
					Ari_peso.put(llave, peso);
				}			
			}else if(ent == true) {
				while(clave.hasNext()){
					llave = clave.next();
					peso = (rgo * Math.random())+min;
					Ari_peso.put(llave, Math.floor(peso));
				}
			}
		
		Iterator<String> llave2 = Arista.keySet().iterator();
		while (llave2.hasNext()) {
			llave = llave2.next();
		}
		
		return Ari_peso;
			
		}
		
		//Clasificador y administrador de aristas del grafo dirigido
		public static HashMap<String,Double> Clas_Arista_D(String nodo,Double peso, HashMap<String,Double> Arista,HashMap<String,Double> Clas){
			String llave;
			String nod1;
			String nod2;
			Iterator<String> clave = Arista.keySet().iterator();
				while (clave.hasNext()) {
					llave =clave.next();
					if (llave.contains(nodo)) {
						nod1= llave.substring(0, llave.indexOf("-"));
						nod2= llave.substring(llave.indexOf("-")+2, llave.length());
						if (nodo.equalsIgnoreCase(nod1) & !nodo.equalsIgnoreCase(nod2)) {
							Clas.put(llave,Arista.get(llave)+peso);
						}
					}
				}	
				
			return Clas;
		}
		
		//Clasificador y administrador de aristas del grafo no dirigido
		public static HashMap<String,Double> Clas_Arista_ND(String nodo,Double peso, HashMap<String,Double> Arista,HashMap<String,Double> Clas){
			String llave;
			String nod1;
			String nod2;
			Iterator<String> clave = Arista.keySet().iterator();
				while (clave.hasNext()) {
					llave =clave.next();
					if (llave.contains(nodo)) {
						nod1= llave.substring(0, llave.indexOf("-"));
						nod2= llave.substring(llave.indexOf("-")+2, llave.length());
							if (nodo.equalsIgnoreCase(nod1) & !nodo.equalsIgnoreCase(nod2) ) {
								Clas.put(llave, Arista.get(llave)+peso);
							}else if (!nodo.equalsIgnoreCase(nod1) & nodo.equalsIgnoreCase(nod2)) {
								Clas.put(nod2+"--"+nod1, Arista.get(llave)+peso);
							}
					}
				}	
			return Clas;
		}
		
		//Solicita los valores mínimos y máximos para Diajkstra
		public static double valor(int a) {
			double num =0;
			Scanner datos = new Scanner(System.in);
			String opc;
			switch(a) {
			case 1:
				System.out.println("Valores para calcular los pesos de las aristas");
				System.out.println("  Inserte el inicio del intervalo");
					num = datos.nextDouble();
				break;
			case 2:
				System.out.println("  Inserte el fin del intervalo");
				num = datos.nextDouble();
				break;
			case 3:
				System.out.println("  Intervalo invalido,");
				System.out.println("  favor de ingresar un nuevo intervalo: ");
				System.out.println("  Inserte el inicio del intervalo");
				num = datos.nextDouble();
			default:
				System.out.println("  Opción Invalida");
			}
			return num;
			}
		
		//Extrae los pesos de las aristas del algoritmo de Dijkstra
		public static HashMap<String,Double> Ari_peso_real(HashMap<String,Double> ap,HashMap<String,Double> ar,boolean dir){
			String clave,nod1,nod2;
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			Iterator <String> llave = ar.keySet().iterator();
			if (dir == true) {
				while(llave.hasNext()) {
					clave = llave.next();
					clave = clave.replace("--", "->");
					Arbol.put(clave, ap.get(clave));
				}
			} else if (dir == false) {
				while (llave.hasNext()) {
					clave= llave.next();
					nod1 = clave.substring(0, clave.indexOf("-"));
					nod2 = clave.substring(clave.indexOf("-")+2, clave.length());
					if (ap.containsKey(nod1+"--"+nod2)) {
						Arbol.put(clave, ap.get(nod1+"--"+nod2));
					}else if(ap.containsKey(nod2+"--"+nod1)) {
						Arbol.put(clave,ap.get(nod2+"--"+nod1));
					}
				}
			}
		return Arbol;		
		}
		
		//Algoritmo de Dijsktra
		public static HashMap<String,Double> Dijkstra(HashMap<String,Double> aristas,String Nd_ori,String Nd_fin,boolean dir) throws IOException {
			Grafos g = new Grafos();
			HashMap<String,Double> Ari_pesos = new HashMap<String,Double>();
			HashMap<String,Double> Ari_class = new HashMap<String,Double>();
			HashMap<Integer,String> Ari_lim = new HashMap<Integer,String>();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<Integer,String> visit = new HashMap<Integer,String>();
			double peso;
			Ari_pesos = aristas;
			if (Nd_ori.equalsIgnoreCase(Nd_fin)) {
				if(Ari_pesos.containsKey(Nd_ori+"--"+Nd_fin)) {
					System.out.println("El costo de ir de "+Nd_ori + "a "+Nd_fin + "es de:" +String.format("%.2f", Ari_pesos.get(Nd_ori+"--"+Nd_fin)));
				} else if(aristas.containsKey(Nd_ori+"->"+Nd_fin)) {
					System.out.println("El costo de ir de "+Nd_ori + "a "+Nd_fin + "es de:" +String.format("%.2f", Ari_pesos.get(Nd_ori+"->"+Nd_fin)));
				}else {
					System.out.println("No existe camino de "+Nd_ori +" a "+Nd_fin);
				}
			}else {
				peso = 0;
				visit.put(visit.size(), Nd_ori);
				String clave,arista = null,nodo,nodo_fin=null,nodo_val=Nd_ori;
				if (dir == true) {
					Ari_class = g.Clas_Arista_D(Nd_ori, peso,Ari_pesos, Ari_class);
				}else if (dir == false) {
					Ari_class = g.Clas_Arista_ND(Nd_ori, peso,Ari_pesos, Ari_class);
				}
					while(!visit.containsValue(Nd_fin) & !Ari_class.isEmpty() & nodo_fin!=nodo_val) {
						peso = Double.POSITIVE_INFINITY;
						nodo_val=nodo_fin;
						Iterator<String> llave = Ari_class.keySet().iterator();
						while (llave.hasNext()) {
							clave = llave.next();
							nodo = clave.substring(clave.indexOf("-")+2, clave.length());
							if (Ari_class.get(clave)<peso & !visit.containsValue(nodo) ){
								arista = clave;
								peso = Ari_class.get(clave);
								nodo_fin= nodo;
							}
							if (visit.containsValue(nodo)) {
								Ari_lim.put(Ari_lim.size(), clave);
							}
						}
						for (int k =0;k<Ari_lim.size();k++) {
							Ari_class.remove(Ari_lim.get(k));
						}
						Ari_lim.clear();
						Arbol.put(arista, peso);
						if (dir == true) {
							Ari_class = g.Clas_Arista_D(nodo_fin, peso,Ari_pesos, Ari_class);
						}else if (dir == false) {
							Ari_class = g.Clas_Arista_ND(nodo_fin, peso,Ari_pesos, Ari_class);
						}
						visit.put(visit.size(), nodo_fin);
					}	
				//}
			
				if(visit.containsValue(Nd_fin)) {
					System.out.println("El camino mas corto de " +Nd_ori+" a " +Nd_fin+ " es de:");
					System.out.println(String.format("%.2f", peso)+ " Unidades");
				} else {
					System.out.println("No existe camino entre el " + Nd_ori +" a "+Nd_fin);
				}
				
			}
			Arbol = g.Ari_peso_real(Ari_pesos, Arbol, dir);
			return Arbol;
			
		}
		
		//Algoritmo de Dijsktra completo Nodo origen.
		public static HashMap<String,Double> Dijkstra_com(HashMap<String,Double> aristas,String Nd_ori,boolean dir) throws IOException {
			Grafos g = new Grafos();
			HashMap<String,Double> Ari_pesos = new HashMap<String,Double>();
			HashMap<String,Double> Ari_class = new HashMap<String,Double>();
			HashMap<Integer,String> Ari_lim = new HashMap<Integer,String>();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<String,Double> Arbol_com = new HashMap<String,Double>();
			HashMap<Integer,String> nodos = new HashMap<Integer,String>();
			HashMap<Integer,String> visit = new HashMap<Integer,String>();
			double peso;
			Scanner datos = new Scanner(System.in);
			Ari_pesos = aristas;
				peso = 0;
				nodos = g.ext_d(aristas);
				visit.put(visit.size(), Nd_ori);
				String clave,arista = null,nodo,nodo_fin=null,nodo_val=Nd_ori;
				//System.out.println("PR2");
				if (dir == true) {
					Ari_class = g.Clas_Arista_D(Nd_ori, peso,Ari_pesos, Ari_class);
				}else if (dir == false) {
					Ari_class = g.Clas_Arista_ND(Nd_ori, peso,Ari_pesos, Ari_class);
				}
					while(nodos.size() != visit.size() & nodo_fin!=nodo_val) {
						peso = Double.POSITIVE_INFINITY;
						nodo_val=nodo_fin;
						Iterator<String> llave = Ari_class.keySet().iterator();
						while (llave.hasNext()) {
							clave = llave.next();
							nodo = clave.substring(clave.indexOf("-")+2, clave.length());
							if (Ari_class.get(clave)<peso & !visit.containsValue(nodo) ){
								arista = clave;
								peso = Ari_class.get(clave);
								nodo_fin= nodo;
							}
							if (visit.containsValue(nodo)) {
								Ari_lim.put(Ari_lim.size(), clave);
							}
						}
						for (int k =0;k<Ari_lim.size();k++) {
							Ari_class.remove(Ari_lim.get(k));
						}
						Ari_lim.clear();
						if (nodo_fin.equalsIgnoreCase(nodo_val) ) {
							for (int k =0;k<nodos.size();k++) {
								if (!visit.containsValue(nodos.get(k))) {
									nodo_fin = nodos.get(k);
									k=nodos.size();
									peso = 0;
								}
							}
						}else if (!nodo_fin.equalsIgnoreCase(nodo_val) ) {
							Arbol.put(arista, peso);
						}
						if (dir == true) {
							Ari_class = g.Clas_Arista_D(nodo_fin, peso,Ari_pesos, Ari_class);
						}else if (dir == false) {
							Ari_class = g.Clas_Arista_ND(nodo_fin, peso,Ari_pesos, Ari_class);
						}
						visit.put(visit.size(), nodo_fin);
					}	
				//}
				Arbol_com=Arbol;
				Arbol = g.Ari_peso_real(Ari_pesos, Arbol, dir);
				String clave2;
				double pt=0;
				Iterator <String> llave2 = Arbol.keySet().iterator();
				while (llave2.hasNext()) {
					clave2 = llave2.next();
					pt = pt + Arbol.get(clave2);
				}
				System.out.println("El camino de Dijkstra del "+Nd_ori+" es de: " +String.format("%.2f", pt)+ " Unidades");
				System.out.println("Desea guardar las aristas con los: ");
				System.out.println("1. Pesos acumulados.");
				System.out.println("2. Pesos reales.");
				int op = datos.nextInt();
				switch (op) {
				case 1:
					return Arbol_com;
				case 2:
					return Arbol;
				default:
					return Arbol;
				}
			
		}
		
		//Proyecto 2
		public static HashMap <String,Integer> Proy_2 (HashMap<String,Integer> Arista, boolean dir){
			Grafos g = new Grafos();
			HashMap<String,Integer> Arbol = new HashMap<String,Integer>();
			System.out.println("¿Desea aplicar alguno de los siguientes metodos, al grafo generado?");
			System.out.println("1. BFS (Breadth First Search)");
			System.out.println("2. DFS (Depth First Search) Iterativo");
			System.out.println("3. DFS (Depth First Search) Recursivo");
			System.out.println("4. Salir");
			Scanner datos = new Scanner(System.in);
			int Opcion = datos.nextInt();
			switch(Opcion) {
			case 1:
				String Nod = g.Nodo_arb(Arista,0);
				Arbol = g.bfs(Nod, Arista, dir);
				//g.Aristas(Arbol);
				break;
			case 2:
				Nod = g.Nodo_arb(Arista,0);
				Arbol = g.dfs_ite(Nod,Arista, dir);
				//g.Aristas(Arbol);
				break;
			case 3:
				Nod = g.Nodo_arb(Arista,0);
				Arbol = g.dfs_rec(Nod, Arista, Arbol , dir);
				//g.Aristas(Arbol);
			case 4:
				System.out.println("Gracias!!");
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}
			return Arbol;
			
		}
		
		//Base del proyecto 3
		public static HashMap<String,Double> Proy_3(HashMap<String,Double> ari_pesos,HashMap<String,Integer> arista, boolean dir) throws IOException{
			Grafos g = new Grafos();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<String,Double> Ari_peso = new HashMap<String,Double>();
			System.out.println("¿Desea aplicar alguno de los siguientes metodos, al grafo generado?");
			System.out.println("1. Algoritmo de Dijkstra (Dos nodos)");
			System.out.println("2. Algoritmo de Dijkstra (Completo)");
			System.out.println("3. Salir");
			Scanner datos = new Scanner(System.in);
			int Opcion = datos.nextInt();
			switch(Opcion) {
			case 1:
				String nodo_ori = g.Nodo_arb(arista, 1);
				String nodo_fin = g.Nodo_arb(arista, 2);
				Arbol = g.Dijkstra(ari_pesos, nodo_ori, nodo_fin, dir);
				g.Aristas_p(Arbol);
				break;
			case 2:
				//System.out.println(arista.size());
				nodo_ori = g.Nodo_arb(arista, 1);
				Arbol = g.Dijkstra_com(ari_pesos, nodo_ori, dir);
				g.Aristas_p(Arbol);
				break;
			case 3:
				System.out.println("Gracias!!");
				break;
			default:
				System.out.println("Opción Invalida");
				break;
			}
			return Arbol;
		}
		
		//Base del proyecto 3
		public static HashMap<String,Double> Proy_4(HashMap<String,Double> ari_pesos,HashMap<String,Integer> arista,boolean dir) throws IOException{
			Grafos g = new Grafos();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<String,Double> Ari_peso = new HashMap<String,Double>();
			//HashMap<Integer,String> Visit = new HashMap<Integer,String>();
			System.out.println("¿Desea aplicar alguno de los siguientes metodos, al grafo generado?");
			System.out.println("1. Algoritmo de Prim");
			System.out.println("2. Algoritmo de Kruskal directo");
			System.out.println("3. Algoritmo de Kruskal reversivo");
			System.out.println("4. Todos los algoritmos");
			System.out.println("5. Salir");
			Scanner datos = new Scanner(System.in);
			int Opcion = datos.nextInt();
			switch(Opcion) {
			case 1:
				String nodo_ori = g.Nodo_arb(arista, 1);
				Arbol = g.Prim(ari_pesos, nodo_ori, dir);
				g.Aristas_p(Arbol);
				break;
			case 2:
				Arbol = g.Kruskal(ari_pesos, dir);
				g.Aristas_p(Arbol);
				break;
		
			case 3:
				Arbol = g.Kruskal_Rev(ari_pesos, arista, dir);
				g.Aristas_p(Arbol);
				break;
			case 4:
				nodo_ori = g.Nodo_arb(arista, 1);
				Arbol = g.Prim(ari_pesos, nodo_ori, dir);
				g.Aristas_p(Arbol);
				Arbol = g.Kruskal(ari_pesos, dir);
				g.Aristas_p(Arbol);
				Arbol = g.Kruskal_Rev(ari_pesos, arista, dir);
				g.Aristas_p(Arbol);
				break;
			case 5:
				System.out.println("Gracias!!");
				break;
			default:
				System.out.println("Opción Invalida");
				break;
		
			}
			return Arbol;
		}
		
		//Generador de pesos en Aristas
		public HashMap<String,Double> Ari_gral(HashMap<String,Integer> arista) throws IOException{
			Grafos g = new Grafos();
			HashMap<String,Double> Ari_pesos = new HashMap<String,Double>();
			System.out.println("   --- Proyecto 3.1 -> Generador de pesos aleatorios en aristas del grafo ---");
			double mi, ma,peso;
			Scanner datos = new Scanner(System.in);
			String opc;
			double min = valor(1);
			double max = valor(2);
			//System.out.println("PR1"+min +" "+max);
			while (min == max) {
				min = valor(3);
				max = valor(2);
			}
			mi = Math.min(min, max);
			ma=Math.max(min, max);
			boolean ent= false;
			System.out.println("¿Desea sólo valores enteros? S/N");
			String opc2 = datos.next();
			opc2= opc2.toUpperCase();
			if(opc2.equalsIgnoreCase("S")) {
				ent = true;
			}
			Ari_pesos = g.Aristas_pesos(arista, mi, ma, ent);
			System.out.println("¿Desea guardar las aristas y sus pesos? S/N");
			String arc = datos.next();
			arc = arc.toUpperCase();
			if(arc.equalsIgnoreCase("S")) {
				g.Aristas_p(Ari_pesos);
			}
			return Ari_pesos;
		}
		
		//Algoritmo de Prim Nodo origen.
		public static HashMap<String,Double> Prim(HashMap<String,Double> Ari_pesos,String Nd_ori,boolean dir) throws IOException {
			Grafos g = new Grafos();
			HashMap<String,Double> Ari_class = new HashMap<String,Double>();
			HashMap<Integer,String> Ari_lim = new HashMap<Integer,String>();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<Integer,String> nodos = new HashMap<Integer,String>();
			HashMap<Integer,String> visit = new HashMap<Integer,String>();
			double peso;
				peso = 0;
				nodos = g.ext_d(Ari_pesos);
				visit.put(visit.size(), Nd_ori);
				String clave,arista = null,nodo,nodo_fin=null,nodo_val=Nd_ori;
				if (dir == true) {
					Ari_class = g.Clas_Arista_D(Nd_ori, peso,Ari_pesos, Ari_class);
				}else if (dir == false) {
					Ari_class = g.Clas_Arista_ND(Nd_ori, peso,Ari_pesos, Ari_class);
				}
					while(nodos.size() != visit.size() & nodo_fin!=nodo_val) {
						peso = Double.POSITIVE_INFINITY;
						nodo_val=nodo_fin;
						Iterator<String> llave = Ari_class.keySet().iterator();
						while (llave.hasNext()) {
							clave = llave.next();
							nodo = clave.substring(clave.indexOf("-")+2, clave.length());
							if (Ari_class.get(clave)<peso & !visit.containsValue(nodo) ){
								arista = clave;
								peso = Ari_class.get(clave);
								nodo_fin= nodo;
							}
							if (visit.containsValue(nodo)) {
								Ari_lim.put(Ari_lim.size(), clave);
							}
						}
						for (int k =0;k<Ari_lim.size();k++) {
							Ari_class.remove(Ari_lim.get(k));
						}
						Ari_lim.clear();
						if (nodo_fin.equalsIgnoreCase(nodo_val)) {
							for (int k =0;k<nodos.size();k++) {
								if (!visit.containsValue(nodos.get(k))) {
									nodo_fin = nodos.get(k);
									k=nodos.size();
									peso=0;
								}
							}
						}else if (!nodo_fin.equalsIgnoreCase(nodo_val)) {
							Arbol.put(arista, peso);
						}
						if (dir == true) {
							Ari_class = g.Clas_Arista_D(nodo_fin, 0.0,Ari_pesos, Ari_class);
						}else if (dir == false) {
							Ari_class = g.Clas_Arista_ND(nodo_fin, 0.0,Ari_pesos, Ari_class);
						}
		
						visit.put(visit.size(), nodo_fin);
					}
				String clave2;
				double pt=0;
				Iterator <String> llave2 = Arbol.keySet().iterator();
				while (llave2.hasNext()) {
					clave2 = llave2.next();
					pt = pt + Arbol.get(clave2);
				}
				System.out.println("El camino de Prim desde del "+Nd_ori+" es de: " +String.format("%.2f", pt)+ " Unidades");
				return Arbol;	
		}
		
		//Ciclo dfs a nodo dado
		public String ciclo_dfs(String nodo, HashMap<String,Integer> arista,String ciclo ) {
			Grafos g = new Grafos();
			String clave,nod,nod2;
			Iterator<String> llave = arista.keySet().iterator();
			while(llave.hasNext()) {
				clave = llave.next();
				nod = clave.substring(0, clave.indexOf("-"));
				nod2 = clave.substring(clave.indexOf("-")+2,clave.length());
				if (nod.equalsIgnoreCase(nodo) & !ciclo.contains(nod2+"-")) {
					ciclo = ciclo+nod2+"-";
					ciclo = g.ciclo_dfs(nod2, arista, ciclo);
				}
			}
			return ciclo;
		}
		
		// ciclos versión 2
		public boolean ciclos2 (String n1, String n2, HashMap<String,String> ver,HashMap<String,Integer> arista) {
			Grafos g = new Grafos();
			boolean cic = false;
			String clave;
			Iterator<String> llave = ver.keySet().iterator();
			while (llave.hasNext() & cic == false) {
				clave = llave.next();
				if(!clave.equalsIgnoreCase(n1) & !clave.equalsIgnoreCase(n2) ) {
					if(ver.get(clave).contains(n1+"-") & ver.get(clave).contains(n2+"-")) {
						cic=true;
					}
				}
			}
			
			if (cic == false) {
				HashMap<String,Integer> arbol = new HashMap<String,Integer>();
				arbol = g.dfs_rec(n1, arista, arbol, false);
				String ciclo = g.ciclo_dfs(n1, arbol, n1+"-");
				if (ciclo.contains(n2+"-")) {
					cic=true;
				}
			}
			
			if (cic == false) {
				HashMap<String,Integer> arbol = new HashMap<String,Integer>();
				arbol = g.dfs_rec(n2, arista, arbol, false);
				String ciclo = g.ciclo_dfs(n2, arbol, n2+"-");
				if (ciclo.contains(n1+"-")) {
					cic=true;
				}
			}
			
			return cic;
		}
		
		//Clúster nodo inicio del vertice Kruskal 
		public HashMap <Integer,String> C_N1(String nod,String nod2,HashMap<String,Double> arb , HashMap<Integer,String> clu){
			Grafos g = new Grafos();
			String llave,n1,n2;
			Iterator<String> key = arb.keySet().iterator();
			while(key.hasNext() & !clu.containsValue(nod2)) {
				llave = key.next();
				if (llave.contains(nod)) {
					n1 = llave.substring(0, llave.indexOf("-"));
					n2 = llave.substring(llave.indexOf("-")+ 2, llave.length());
					if (nod.equalsIgnoreCase(n1) & !nod.equalsIgnoreCase(n2) & !clu.containsValue(n2)) {
						clu.put(clu.size(), n2);
						clu = g.C_N1(n2,nod2, arb, clu);
					}else if(nod.equalsIgnoreCase(n2) & !nod.equalsIgnoreCase(n1) & !clu.containsValue(n1)) {
						clu.put(clu.size(),n1);
						clu = g.C_N1(n1,nod2, arb, clu);
					}
				}
			}		
			return clu;
			}
		
		//Vértices adyacentes por nodo
		public static HashMap<String,String> Ver_Adj(HashMap<String,Integer> arista){
			HashMap<String,String> ciclos = new HashMap<String,String>();
			String clave,n1,n2;
			Iterator <String> llave = arista.keySet().iterator();
			while (llave.hasNext()) {
				clave = llave.next();
				n1 = clave.substring(0, clave.indexOf("-"));
				n2 = clave.substring(clave.indexOf("-")+2, clave.length());
				if (ciclos.containsKey(n1) & ciclos.containsKey(n2)) {
					ciclos.put(n1, ciclos.get(n1)+n2+"-");
					ciclos.put(n2, ciclos.get(n2)+n1+"-");
				}else if (!ciclos.containsKey(n1) & !ciclos.containsKey(n2)) {
					ciclos.put(n1, n1+"-"+n2+"-");
					ciclos.put(n2, n2+"-"+n1+"-");
				}else if (!ciclos.containsKey(n1) & ciclos.containsKey(n2)) {
					ciclos.put(n1, n1+"-"+n2+"-");
					ciclos.put(n2, ciclos.get(n2)+n1+"-");
				}else if (ciclos.containsKey(n1) & !ciclos.containsKey(n2)) {
					ciclos.put(n2, n2+"-"+n1+"-");
					ciclos.put(n1, ciclos.get(n1)+n2+"-");
				}
			}
			return ciclos;		
			
		}
		
		//Extracción de nodos versión double	
		public static  HashMap<Integer,String> ext_d( HashMap<String,Double> a){
			HashMap<String,Double> aristas = new HashMap<String,Double> ();
			HashMap<String,String> nodo = new HashMap<String,String> ();
			HashMap<Integer,String> nodo_f = new HashMap<Integer,String> ();
			aristas= a;
			Iterator<String> ar = aristas.keySet().iterator();
		    while(ar.hasNext()){
		        String clave = ar.next();
		        int n= clave.indexOf("-");
		        String x = clave.substring(0, n);
		        String y = clave.substring(n+2, clave.length());
		        nodo.put(x,x);
		        nodo.put(y,y);	
			}
		    Iterator<String> ar1=nodo.keySet().iterator();
		    int b=0;
		    while (ar1.hasNext()) {
		    	String d =ar1.next();
		    	nodo_f.put(b,d);
		    	b=b+1;
		    }
		return nodo_f;	
		}
		
		//Algoritmo de Kruskal completo Nodo origen.
		public static HashMap<String,Double> Kruskal(HashMap<String,Double> Ari_pesos,boolean dir) throws IOException {
			Grafos g = new Grafos();
			HashMap<String,Integer> Ari_class = new HashMap<String,Integer>();
			HashMap<Integer,String> Ari_lim = new HashMap<Integer,String>();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<Integer,String> nodos = new HashMap<Integer,String>();
			HashMap<Integer,String> visit = new HashMap<Integer,String>();
			HashMap<Integer,String> clu = new HashMap<Integer,String>();
			double mi, ma,peso;
				peso = 0;
				nodos = g.ext_d(Ari_pesos);
				LinkedHashMap<String,Double> Org_Ari = Ari_pesos.entrySet().stream().sorted(Entry.comparingByValue())
						.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (x,y) -> y, LinkedHashMap::new));
				String clave,arista = null,nodo,nodo2,nodo_fin=null;
						Iterator<String> llave = Org_Ari.keySet().iterator();
						while (llave.hasNext() & Arbol.size() < (nodos.size()-1)) {
							clave = llave.next();
							nodo = clave.substring(0, clave.indexOf("-"));
							nodo2 = clave.substring(clave.indexOf("-")+2, clave.length());
							if (!visit.containsValue(nodo) || !visit.containsValue(nodo2) ){
								Arbol.put(clave.replace("->", "--"), Org_Ari.get(clave));
								Ari_class.put(clave.replace("->", "--"), Ari_class.size());
							}else {
								clu.put(clu.size(), nodo);
								clu = g.C_N1(nodo,nodo2, Arbol, clu);
								if (!clu.containsValue(nodo2)) {
									Arbol.put(clave.replace("->", "--"), Org_Ari.get(clave));
									Ari_class.put(clave.replace("->", "--"), Ari_class.size());
								}
								clu.clear();
							}
		
						visit = g.ext(Ari_class);
					}
				String clave2;
				double pt=0;
				Iterator <String> llave2 = Arbol.keySet().iterator();
				while (llave2.hasNext()) {
					clave2 = llave2.next();
					pt = pt + Arbol.get(clave2);
				}
				System.out.println("El camino de Kruskal es de: " +String.format("%.2f", pt)+ " Unidades");
				return Arbol;
		}
		
		//Algoritmo de Kruskal Reversivo completo Nodo origen.
		public static HashMap<String,Double> Kruskal_Rev(HashMap<String,Double> Ari_pesos,HashMap<String,Integer> aristas,boolean dir) throws IOException {
			Grafos g = new Grafos();
			HashMap<String,Double> Arbol = new HashMap<String,Double>();
			HashMap<String,Integer> visit = new HashMap<String,Integer>();
			HashMap<String,String> ver_adj = new HashMap<String,String>();
				ver_adj = g.Ver_Adj(aristas);
				LinkedHashMap<String,Double> Org_Ari = Ari_pesos.entrySet().stream().sorted(Entry.comparingByValue(Comparator.reverseOrder()))
						.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (x,y) -> y, LinkedHashMap::new));
				String clave,nodo,nodo2;
						Iterator<String> llave = Org_Ari.keySet().iterator();
						while (llave.hasNext()) {
							boolean ciclo = false;
							clave = llave.next();
							nodo = clave.substring(0, clave.indexOf("-"));
							nodo2 = clave.substring(clave.indexOf("-")+2, clave.length());
							aristas.remove(clave);
							ver_adj.put(nodo, ver_adj.get(nodo).replace(nodo2+"-", ""));
							ver_adj.put(nodo2, ver_adj.get(nodo2).replace(nodo+"-", ""));
							boolean cic = g.ciclos2(nodo, nodo2, ver_adj, aristas);
							if (cic == false) {
								aristas.put(clave, aristas.size());
								Arbol.put(clave, Ari_pesos.get(clave));
								ver_adj.put(nodo, ver_adj.get(nodo)+nodo2+"-");
								ver_adj.put(nodo2, ver_adj.get(nodo2)+nodo+"-");
							}
							}
				String clave2;
				double pt=0;
				Iterator <String> llave2 = Arbol.keySet().iterator();
				while (llave2.hasNext()) {
					clave2 = llave2.next();
					pt = pt + Arbol.get(clave2);
				}
				System.out.println("El camino de Kruskal Reversivo es de: " +String.format("%.2f", pt)+ " Unidades");
				return Arbol;
		}
		
		public static void main (String [] args) throws IOException {
		//String Final ="s";
		//while (Final == "s" || Final == "S") {
		Grafos g = new Grafos();
		int n = 0;
		Scanner datos = new Scanner(System.in);
		HashMap <String,Integer> nodos = new HashMap <String, Integer>();
		HashMap <Integer,Double> Esp= new HashMap<Integer,Double>();
		HashMap <String,Integer> Met = new HashMap <String, Integer>();
		HashMap <String,Integer> Met2 = new HashMap <String, Integer>();
		HashMap <String,Integer> Met5 = new HashMap <String, Integer>();
		HashMap <String,Double> Met3 = new HashMap <String, Double>();
		HashMap <String,Double> Met4 = new HashMap <String, Double>();
		//HashMap <String,Double> Met4 = new HashMap <String, Double>();
		System.out.println("   --- Proyecto 1 -> Generador de Grafos ---"); 
		System.out.println("Menú para seleccionar tipo de grafo");
		System.out.println("1. Modelo de Erdös y Rényi");
		System.out.println("2. Modelo de Gilbert");
		System.out.println("3. Modelo geográfico simple");
		System.out.println("4. Modelo Barabási-Albert");
		System.out.println("5. Salir");
		int Opcion = datos.nextInt();
		switch(Opcion) {
		case 1:
			System.out.println("Ingrese el número de Nodos");
			n=datos.nextInt();
			System.out.println("Ingrese el número de Aristas");
			int m =datos.nextInt();
			System.out.println("Grafo dirigido (True/False)");
			boolean d =datos.nextBoolean();
			System.out.println("Aristas Autodirigidas (True/False)");
			boolean a =datos.nextBoolean();
			Met=g.G_ER(n, m, d, a);
			Met5.putAll(Met);
			g.Aristas(Met);
			System.out.println("   --- Proyecto 2 -> Algoritmos de Búsqueda ---");
			Met2 = g.Proy_2(Met, d);
			if(Met2.size()>0) {
				//System.out.println(Met2.size());
				g.Aristas(Met2);
			}
			Met3 = g.Ari_gral(Met5);
			Met4.putAll(Met3);
			System.out.println("   --- Proyecto 3 -> Algoritmo de Dijkstra ---");
			g.Proy_3(Met3,Met5, d);
			System.out.println("   --- Proyecto 4 -> Algoritmos Árbol de Expansión Mínima ---");
			g.Proy_4(Met4, Met5, d);
			//System.out.println("Regresar al Menú (S/N)");
			//Final = datos.next();
			break;
		case 2:
			System.out.println("Ingrese el número de Nodos");
			n=datos.nextInt();
			System.out.println("Ingrese la probabilidad");
			double p =datos.nextDouble();
			System.out.println("Grafo dirigido (True/False)");
			d =datos.nextBoolean();
			System.out.println("Aristas Autodirigidas (True/False)");
			a =datos.nextBoolean();
			Met=g.G_Gil(n, p, d, a);
			g.Aristas(Met);
			System.out.println("   --- Proyecto 2 -> Algoritmos de Búsqueda ---");
			Met2 = g.Proy_2(Met, d);
			if(Met2.size()>0) {
				g.Aristas(Met2);
			}
			System.out.println("   --- Proyecto 3 -> Algoritmo de Dijkstra ---");
			g.Proy_3(Met3,Met, d);
			System.out.println("   --- Proyecto 4 -> Algoritmos Árbol de Expansión Mínima ---");
			g.Proy_4(Met4, Met, d);
			//System.out.println("Regresar al Menú (S/N)");
			//Final = datos.next();
			break;
		case 3:
			System.out.println("Ingrese el número de Nodos");
			n=datos.nextInt();
			System.out.println("Ingrese la distancia entre nodos");
			double r =datos.nextDouble();
			System.out.println("Grafo dirigido (True/False)");
			d =datos.nextBoolean();
			System.out.println("Aristas Autodirigidas (True/False)");
			a =datos.nextBoolean();
			Met=g.G_Geo(n, r, d, a);
			g.Aristas(Met);
			System.out.println("   --- Proyecto 2 -> Algoritmos de Búsqueda ---");
			Met2 = g.Proy_2(Met, d);
			if(Met2.size()>0) {
				g.Aristas(Met2);
			}
			System.out.println("   --- Proyecto 3 -> Algoritmo de Dijkstra ---");
			g.Proy_3(Met3,Met, d);
			System.out.println("   --- Proyecto 4 -> Algoritmos Árbol de Expansión Mínima ---");
			g.Proy_4(Met4, Met, d);
			//System.out.println("Regresar al Menú (S/N)");
			//Final = datos.next();
			break;
		case 4:
			System.out.println("Ingrese el número de Nodos");
			n=datos.nextInt();
			System.out.println("Ingrese el numero de aristas por nodo");
			m =datos.nextInt();
			System.out.println("Grafo dirigido (True/False)");
			d =datos.nextBoolean();
			System.out.println("Aristas Autodirigidas (True/False)");
			a =datos.nextBoolean();
			Met=g.G_Bar(n, m, d, a);
			g.Aristas(Met);
			System.out.println("   --- Proyecto 2 -> Algoritmos de Búsqueda ---");
			Met2 = g.Proy_2(Met, d);
			if(Met2.size()>0) {
				g.Aristas(Met2);
			}
			System.out.println("   --- Proyecto 3 -> Algoritmo de Dijkstra ---");
			g.Proy_3(Met3,Met, d);
			System.out.println("   --- Proyecto 4 -> Algoritmos Árbol de Expansión Mínima ---");
			g.Proy_4(Met4, Met, d);
			//System.out.println("Regresar al Menú (S/N)");
			//Final = datos.next();
			break;
		case 5:
			//Final = "N";
			System.out.println("Gracias!");
			break;
		default:
			System.out.println("Opción invalida");
			//Final = "N";
		}System.out.println("!Gracias!");
		}
		}

