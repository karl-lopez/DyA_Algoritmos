package DAAlgoritmos;

import java.io.*;
import java.util.*;

//import pruebas.Grafos;



	public class Grafos {

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
						if(M_ER.containsKey("Nodo"+N1+"--Nodo"+N2)) {
							i=i-1;
					}else {
						M_ER.put("Nodo"+N1+"--Nodo"+N2, i);
					}
					}else {
						if(M_ER.containsKey("Nodo"+N1+"--Nodo"+N2) || N1==N2) {
							i=i-1;
						}else {
							M_ER.put("Nodo"+N1+"--Nodo"+N2, i);
						}	
					}				
				}
			}
		return M_ER;	
		}
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
		public static String Nodo_arb (HashMap<String,Integer> Ari) {
			Grafos g = new Grafos();
			HashMap<Integer,String> nvo_nodos = new HashMap<Integer,String> ();
			HashMap<String,Integer> aristas = new HashMap<String,Integer> ();
			Scanner datos = new Scanner(System.in);
			nvo_nodos= g.ext(Ari);
			aristas = Ari;
			String nodo = null;
			int res = 0;
			// Validación del nodo solicitado
				System.out.println("¿Desea inserta el nodo? S/N");
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
				String Nod = g.Nodo_arb(Arista);
				Arbol = g.bfs(Nod, Arista, dir);
				//g.Aristas(Arbol);
				break;
			case 2:
				Nod = g.Nodo_arb(Arista);
				Arbol = g.dfs_ite(Nod,Arista, dir);
				//g.Aristas(Arbol);
				break;
			case 3:
				Nod = g.Nodo_arb(Arista);
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
				//g.Aristas(Met);
				Met2 = g.Proy_2(Met, d);
				if(Met2.size()>0) {
					//System.out.println(Met2.size());
					//g.Aristas(Met2);
				}
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
				Met2 = g.Proy_2(Met, d);
				if(Met2.size()>0) {
					//System.out.println(Met2.size());
					g.Aristas(Met2);
				}
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
				Met2 = g.Proy_2(Met, d);
				if(Met2.size()>0) {
					//System.out.println(Met2.size());
					g.Aristas(Met2);
				}
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
				Met2 = g.Proy_2(Met, d);
				if(Met2.size()>0) {
					//System.out.println(Met2.size());
					g.Aristas(Met2);
				}
				//System.out.println("Regresar al Menú (S/N)");
				//Final = datos.next();
				break;
			case 5:
				//Final = "N";
				System.out.println("Gracias!");
				break;
			default:
				System.out.println("Opción invalidad");
				//Final = "N";
			}System.out.println("!Gracias!");
			}
			//} 
		}

