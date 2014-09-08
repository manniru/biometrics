package com.mnice;

public class Test {

	public static void main(String[] args) {
		Staff staff = new Staff();
		StaffDao dao = new StaffDao();
		
		Staff st = dao.load(1);
		///System.out.println(st.getFullname());
		///dao.create("STAFF");
		dao.addStaff(st);
		
		///Staff staff2 = dao.getStaff(3);
		///System.out.println(staff2.getFullname());
		System.out.println(st.getFullname());
		st.setFullname("Auwal Ibrahim 3");
		dao.updateStaff(st);
		System.out.println(st.getFullname());

		

	}

}
