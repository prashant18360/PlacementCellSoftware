//package ap_assign1;

import java.util.*;
public class Placement {
	
	class Company {
		
			private String cname;
			private int cours_num;
			private int reqnum;
			private Hashtable<Integer, Integer> hrolmk = new Hashtable<Integer, Integer>();
			private ArrayList<Integer> tech = new ArrayList<Integer>();
			private ArrayList<String> courses = new ArrayList<String>();
			private String status;
			private int select_num;
			
			
			public Company(String cname, int cours_num, int reqnum, ArrayList<String> courses, Hashtable<Integer, Integer> hrolmk, ArrayList<Integer> tech, int select_num) {
					
					this.setCname(cname);
					this.setCours_num(cours_num);
					this.setReqnum(reqnum);
					this.setHrolmk(hrolmk);
					this.setTech(tech);
					this.setCourses(courses);
					this.setStatus("OPEN");
					this.setSelect_num(select_num);
			}
			
			
			public String getCname() {
				return cname;
			}
			public void setCname(String cname) {
				this.cname = cname;
			}
			public int getCours_num() {
				return cours_num;
			}
			public void setCours_num(int cours_num) {
				this.cours_num = cours_num;
			}
			public int getReqnum() {
				return reqnum;
			}
			public void setReqnum(int reqnum) {
				this.reqnum = reqnum;
			}
			public Hashtable<Integer, Integer> getHrolmk() {
				return hrolmk;
			}
			public void setHrolmk(Hashtable<Integer, Integer> hrolmk) {
				this.hrolmk = hrolmk;
			}
			public ArrayList<Integer> getTech() {
				return tech;
			}
			public void setTech(ArrayList<Integer> tech) {
				this.tech = tech;
			}
			public ArrayList<String> getCourses() {
				return courses;
			}
			public void setCourses(ArrayList<String> courses) {
				this.courses = courses;
			}
			public String getStatus() {
				return status;
			}
			public void setStatus(String status) {
				this.status = status;
			}
			public int getSelect_num() {
				return select_num;
			}
			public void setSelect_num(int select_num) {
				this.select_num = select_num;
			}
			

	}
	
	
	
	
	class Student {
		
			private int roll;
			private float cgpa;
			private String course;
			private boolean plac_status;
			private String comp_name;
			private ArrayList<String> com_tot = new ArrayList<String>();
			private ArrayList<Integer> com_tmark = new ArrayList<Integer>();
			
			
			public Student(int roll, float cgpa, String course) {
				this.setRoll(roll);
				this.setCgpa(cgpa);
				this.setCourse(course);
				this.setComp_name("Nothing");
				this.setPlac_status(false);
			}
			
			public int getRoll() {
				return roll;
			}
			public void setRoll(int roll) {
				this.roll = roll;
			}
			public float getCgpa() {
				return cgpa;
			}
			public void setCgpa(float cgpa) {
				this.cgpa = cgpa;
			}
			public String getCourse() {
				return course;
			}
			public void setCourse(String course) {
				this.course = course;
			}
			public boolean isPlac_status() {
				return plac_status;
			}
			public void setPlac_status(boolean plac_status) {
				this.plac_status = plac_status;
			}
			public String getComp_name() {
				return comp_name;
			}
			public void setComp_name(String comp_name) {
				this.comp_name = comp_name;
			}
			public ArrayList<String> getCom_tot() {
				return com_tot;
			}
			public void setCom_tot(ArrayList<String> com_tot) {
				this.com_tot = com_tot;
			}
			public ArrayList<Integer> getCom_tmark() {
				return com_tmark;
			}
			public void setCom_tmark(ArrayList<Integer> com_tmark) {
				this.com_tmark = com_tmark;
			}
			
			
	}
	
	
		private ArrayList<Company> comp = new ArrayList<Company>();
		private ArrayList<Student> stud = new ArrayList<Student>();
		
		
		public void AddCompany(String cn, int cour_num, int rnum, ArrayList<String> cours, Hashtable<Integer, Integer> hrm, ArrayList<Integer> tc, int sel_num) {
				Company c = new Company(cn,cour_num,rnum,cours, hrm, tc,sel_num);
				comp.add(c);
		}
		
	
		public void AddStudent(int r, float cg, String cour) {
				Student s = new Student(r,cg,cour);
				stud.add(s);
		}
		
		
		public void Dispstudent(int r) {
			int l = stud.size();
			for(int j=0;j<l;j++) {
				Student st = stud.get(j);
				if(st.getRoll() == r) {
					System.out.println(st.getRoll());
					System.out.println(st.getCgpa());
					System.out.println(st.getCourse());
					if(st.isPlac_status()) {
						System.out.println("Placement status : " + "Placed");
						System.out.println("Company name : " + st.getComp_name());
					}
					else {
						System.out.println("Placement status : " + "Not Placed");
						System.out.println("Company name : " + st.getComp_name());
					}
				}
			}	
		}
		
		
		public void Dispcompany(String s) {
			int l = comp.size();
			for(int j=0;j<l;j++) {
				Company cp = comp.get(j);
				if(cp.getCname().compareTo(s) == 0) {
					System.out.println(cp.getCname());
					System.out.println("Course criteria");
					for(int k=0;k<cp.getCours_num();k++) {
						System.out.println(cp.getCourses().get(k));
					}
					System.out.println("Number of Required Students = " + cp.getReqnum());
					System.out.println("Application Status = " + cp.getStatus());
				}
			}
		}
		
		
		public void Dispcomp_name() {
			int l = comp.size();
			for(int j=0;j<l;j++) {
				Company cp = comp.get(j);
				if(cp.getStatus().compareTo("OPEN") == 0) {
					System.out.println(cp.getCname());
				}
			}
		}
		
		
		public void removestudent() {
			Iterator<Student> it = stud.iterator();
			while(it.hasNext()) {
				Student st = it.next();
				if(st.isPlac_status()) {
					System.out.println(st.getRoll());
					it.remove();
				}
			}
		}
		
		
		
		public void removecompany() {
			Iterator<Company> it = comp.iterator(); 
			while(it.hasNext()) {
				Company cp = it.next();
				if(cp.getStatus().compareTo("CLOSED") == 0) {
					System.out.println(cp.getCname());
					it.remove();
				}
			}
		}
		
		
		public ArrayList<Integer> rol_search(ArrayList<String> arr) {
			ArrayList<Integer> arol = new ArrayList<Integer>();
			int ls = stud.size();
			for(int i=0;i<ls;i++) {
				Student st = stud.get(i);
				for(int j=0;j<arr.size();j++) {
					if(st.getCourse().compareTo(arr.get(j)) == 0) {
						arol.add(st.getRoll());
					}	
				}
			}
			return arol;
		}
		
		public void st_ini_tmarks(Hashtable<Integer, Integer> hrolmk, String cname) {
			int l = stud.size();
			for(int i=0;i<l;i++) {
				Student st = stud.get(i);
				if(hrolmk.containsKey(st.getRoll())) {
					ArrayList<Integer> comp_tmark = st.getCom_tmark();
					ArrayList<String> comp_tot = st.getCom_tot();
					comp_tmark.add(hrolmk.get(st.getRoll()));
					st.setCom_tmark(comp_tmark);
					comp_tot.add(cname);
					st.setCom_tot(comp_tot);
					stud.set(i, st);
				}
			}
		}
		
		public void company_eligib(int rol) {
			int l = stud.size();
			for(int i=0;i<l;i++) {
				Student st = stud.get(i);
				if(st.getRoll() == rol) {
					int ltp = st.getCom_tmark().size();
					ArrayList<Integer> comp_tmark = st.getCom_tmark();
					ArrayList<String> comp_tot = st.getCom_tot();
					for(int j=0;j<ltp;j++) {
						System.out.println(comp_tot.get(j) + "  " + comp_tmark.get(j));
					}
				}
			}
		}
		
		public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) 
	    { 
	   
	        Set<T> set = new LinkedHashSet<>(); 
	        set.addAll(list); 
	        list.clear();  
	        list.addAll(set); 
	        return list; 
	        
	    } 
		
		public void placed(String cname) {
			int lc = comp.size();
			int ls = stud.size();
			System.out.println("Roll no. of selected Student");
			if(this.getNum()>0) {
				for(int i=0;i<lc;i++) {
					Company cp = comp.get(i);
					if(cp.cname.compareTo(cname) == 0) {
						
						if(cp.getReqnum() >= this.getNum()) {
							cp.setStatus("CLOSED");
							cp.setSelect_num(this.getNum());
							cp.setReqnum(0);
							comp.set(i , cp);
							this.setNum(0);
							comp.set(i, cp);
							for(int j=0;j<ls;j++) {
								Student st = stud.get(j);
								st.setPlac_status(true);
								st.setComp_name(cname);
								System.out.println(st.getRoll());
								stud.set(j, st);
							}
						}
						
						if(cp.getReqnum() < this.getNum()) {
							ArrayList<Integer> v = cp.getTech();
							Hashtable<Integer, Integer> hrolmk = cp.getHrolmk();
							ArrayList<Integer> vr = new ArrayList<Integer>(hrolmk.keySet());
							Collections.sort(v);
							ArrayList<Integer> shortlist = new ArrayList<Integer>();
							int rm = cp.getReqnum();
							int g=v.get(0);
							int f =0,c=1;
							for(int j=1;j<v.size();j++) {
								if(g != v.get(j) ) {
									f=1;
								}
								if(g == v.get(j)) {
									c++;
								}
								//System.out.println("ok");
								g=v.get(j);	
							}
							if(f==0) {
								ArrayList<Float> shorcgpa = new ArrayList<Float>();
								Hashtable<Integer,Float> rc = new Hashtable<Integer,Float>();
								for(int j=0;j<vr.size();j++) {
									shortlist.add(vr.get(j));
								}
								for(int j=0;j<shortlist.size();j++) {
									for(int k=0;k<ls;k++) {
										Student st = stud.get(k);
										if(st.getRoll() == shortlist.get(j)) {
											shorcgpa.add(st.getCgpa());
											rc.put(st.getRoll(), st.getCgpa());
										}
									}
								}
								Collections.sort(shorcgpa);
								Collections.reverse(shorcgpa);
								
								for(int j=0;j<rm;j++) {
									for(int k=0;k<shortlist.size();k++) {
										int ky = shortlist.get(k);
										if((float)shorcgpa.get(j) == (float)rc.get(ky)) {
											for(int l=0;l<ls;l++) {
												Student st = stud.get(l);
												if(st.getRoll() == shortlist.get(k)) {
													System.out.println(st.getRoll());
													st.setComp_name(cname);
													st.setPlac_status(true);
													stud.set(l, st);
												}
											}
										}
										
									}
								}
								cp.setStatus("CLOSED");
								cp.setSelect_num(rm);
								cp.setReqnum(0);
								comp.set(i, cp);
								this.setNum(this.getNum()-rm);
							
							}
							if(f==1) {
								if(rm>=c) {
									ArrayList<Integer> temp =new ArrayList<Integer>();
									Collections.sort(v);
									Collections.reverse(v);
									for(int j=0;j<rm;j++) {
										int t=v.get(j);
										for(int k=0;k<vr.size();k++) {
											if((float)t == (float)hrolmk.get(vr.get(k))) {
												temp.add(vr.get(k));
											}
										}
									}
									
									shortlist = removeDuplicates(temp);
									
									for(int j=0;j<ls;j++) {
										Student st = stud.get(j);
										for(int k=0;k<shortlist.size();k++) {
											if(st.getRoll() == shortlist.get(k)) {
												st.setComp_name(cname);
												st.setPlac_status(true);
												System.out.println(st.getRoll());
												stud.set(j, st);
											}
										}
									}
									cp.setStatus("CLOSED");
									cp.setSelect_num(rm);
									cp.setReqnum(0);
									comp.set(i, cp);
									this.setNum(this.getNum()-rm);
								}
								else {
									ArrayList<Integer> temp = new ArrayList<Integer>();
									for(int j=0;j<c;j++) {
										int t=v.get(j);
										for(int k=0;k<vr.size();k++) {
											if(t == hrolmk.get(vr.get(k))) {
												temp.add(vr.get(k));
											}
											
										}
									
									}
									shortlist = removeDuplicates(temp);
									ArrayList<Float> shorcgpa = new ArrayList<Float>();
									Hashtable<Integer,Float> rc = new Hashtable<Integer,Float>();
									for(int j=0;j<shortlist.size();j++) {
										for(int k=0;k<ls;k++) {
											Student st = stud.get(k);
											if(st.getRoll() == shortlist.get(j)) {
												shorcgpa.add(st.getCgpa());
												rc.put(st.getRoll(), st.getCgpa());
											}
										}
									}
									Collections.sort(shorcgpa);
									Collections.reverse(shorcgpa);
									for(int j=0;j<rm;j++) {
										for(int k=0;k<shortlist.size();k++) {
											int ky = shortlist.get(k);
											if((float)shorcgpa.get(j) == (float)rc.get(ky)) {
												System.out.println(shortlist.get(k));
												for(int l=0;l<ls;l++) {
													Student st = stud.get(l);
													if(st.getRoll() == shortlist.get(k)) {
														System.out.println(st.getRoll());
														st.setComp_name(cname);
														st.setPlac_status(true);
														stud.set(l, st);
													}
												}
											}
										}
									}
									cp.setStatus("CLOSED");
									cp.setSelect_num(rm);
									cp.setReqnum(0);
									comp.set(i, cp);
									this.setNum(this.getNum()-rm);
								
									
								}
								
							}
							
						}
							
					}
				}
			}
			
			
		}
		
		
		private int num;
		
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Placement p = new Placement();
		Scanner in = new Scanner(System.in);
		String n = in.next();
		p.setNum(Integer.parseInt(n));
		for(int i=0;i<p.getNum();i++) {
			float cg = Float.parseFloat(in.next());
			String cours = in.next();
			p.AddStudent(i+1, cg, cours);
		}
		while(p.getNum() != 0) {
			int q = Integer.parseInt(in.next());
			
			if(q == 1) {
				String cname = in.next();
				System.out.println("Number of Eligible Courses");
				int courn = Integer.parseInt(in.next());
				ArrayList<String> arr = new ArrayList<String>();
				for(int i=0;i<courn;i++) {
					arr.add(in.next());
				}
				System.out.println("Number of Required student");
				int rn = Integer.parseInt(in.next());
				ArrayList<Integer> arol = p.rol_search(arr);
				
				
				System.out.println(cname);
				System.out.println("Course criteria");
				for(int i=0;i<courn;i++) {
					System.out.println(arr.get(i));
				}
				System.out.println("Number of Required student = " + rn);
				System.out.println("Application status = OPEN");
				
				
				Hashtable<Integer, Integer> hrolmk = new Hashtable<Integer, Integer>();
				ArrayList<Integer> tech = new ArrayList<Integer>();
				
				System.out.println("Enter score of technical round");
				for(int i=0;i<arol.size();i++) {
					System.out.println("Enter score of Roll no. " + arol.get(i));
					int m = Integer.parseInt(in.next());
					hrolmk.put(arol.get(i), m);
					tech.add(m);
				}
				p.AddCompany(cname, courn, rn, arr, hrolmk,tech , 0);	
				p.st_ini_tmarks(hrolmk, cname);
			}
			
			if(q == 2) {
				p.removestudent();
			}
			
			if(q == 3) {
				p.removecompany();
			}
			
			if(q == 4) {
				System.out.println(p.getNum() + " students left");
			}
			
			if(q == 5) {
				p.Dispcomp_name();
			}
			if(q == 6) {
				String cname = in.next();
				p.placed(cname);
			}
			if(q == 7) {
				String cname = in.next();
				p.Dispcompany(cname);
			}
			
			if(q == 8) {
				int rol = Integer.parseInt(in.next());
				p.Dispstudent(rol);	
			}
			if(q == 9) {
				int rol = Integer.parseInt(in.next());
				p.company_eligib(rol);
			}
		}

	}

}
