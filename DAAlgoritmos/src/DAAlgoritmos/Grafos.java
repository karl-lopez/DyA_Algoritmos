package DAAlgoritmos;

import java.io.*;
import java.util.*;



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
		
		public static void main (String [] args) throws IOException {
			//String Final ="s";
			//while (Final == "s" || Final == "S") {
			Grafos g = new Grafos();
			int n = 0;
			Scanner datos = new Scanner(System.in);
			HashMap <String,Integer> nodos = new HashMap <String, Integer>();
			HashMap <Integer,Double> Esp= new HashMap<Integer,Double>();
			HashMap <String,Integer> Met = new HashMap <String, Integer>();
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
				g.Aristas(Met);
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

