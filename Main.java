import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		
		
		
		
		//--------------------------------------------------initializing connection to database--------------------------------------------------
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "db_e23152_e23021_withsamples";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to database");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//----------------------------------------------------------------------------------------------------------------------------------------
		
		
		
		Scanner scanner = new Scanner(System.in); //make scanner for user int input
		
		while(true) { //endless loop for being able to go back and forward through menus. It ends using the [6] which terminates the program
			
			boolean flag=false; //use for error message
			int select=-1; //initialize user menu selection variable
			
			
			
			
			//-----------------------------------------------------------------home menu----------------------------------------------------------
			do { //check the validity of input value
				try {
					System.out.println("\n\n\n\n\n\n\n\n\n\nSelect action:\n[1]Insert item\n[2]Update item\n[3]Get item\n[4]Reservations\n[5]Exit"); //print home menu
					System.out.print("\nEnter selection: ");
					select = scanner.nextInt();
				}catch(Exception e) {
					e.printStackTrace();
					scanner.next();
					select = 0;
					flag = true;
				}
				if ((flag==false)&&((select<1)||(select>5))) { //check if selection is valid
					System.out.print("Invalid input [Enter numbers between 1 and 5]\n");
				}
				else if(flag){
					System.out.print("Invalid input\n");
				}
				flag=false;
			}while((select<1)||(select>5));
			//-----------------------------------------------------------------------------------------------------------------------------------
			
			
			
			
			switch(select) { //use switch to go to the selected option from the home menu
			
				case 1: //if [1]Insert(home menu) option is selected
					
					boolean flag_back = false; //use for being able to get out of do-while and go back to the home menu
					select = 0;
					
					do { //using do while so that we can go back to the home menu when insert is completed
						
						flag=false; //use for error message
						
						
						
						
						//----------------------------------table selection menu----------------------------------
						do { //check the validity of input value
							try {
								System.out.print("\n\n\n\n\n\n\n\n\n\nSelect table: \n[1]Conference Center\n[2]Conference Room\n[3]Customer\n[4]Back");
								System.out.print("\nEnter selection: ");
								select = scanner.nextInt();
								scanner.nextLine();
							}catch(Exception e) {
								e.printStackTrace();
								scanner.next();
								select = 0;
								flag = true;
							}
							if ((flag==false)&&((select<1)||(select>4))) {
								System.out.print("Invalid input [Enter numbers between 1 and 4]\n");
							}
							else if(flag){
								System.out.print("Invalid input\n");
							}
							flag=false;
						}while((select<1)||(select>4));
						//----------------------------------------------------------------------------------------
						
						
						
						
						switch(select) { //use switch to go to the selected table
						
							case 1: //if [1]Conference Center(insert item menu) is selected
								
								
								//--------initializing variables--------
								String center_code="";
								String center_name="";
								String center_address="";
								String center_city="";
								long center_phone = 0;
								String center_email="";
								String center_services="";
								//--------------------------------------							
								
								
								//-------------------------------------------------------------getting input for table parameters-------------------------------------------------------------
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\nEnter conference center code: ");
										center_code = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_code = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center name: ");
										center_name = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_name = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);

								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center address: ");
										center_address = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_address = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center city: ");
										center_city = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_city = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center phone: ");
										center_phone = scanner.nextLong();
										scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_phone = 0;
										flag = true;
									}
									if ((flag==false)&&((String.valueOf(Math.abs(center_phone)).length())!=10)) {
										System.out.print("Invalid input [Number must be exactly 10 digits!]\n");
										flag=true;
									}
									else if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center email: ");
										center_email = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_email = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference center services: ");
										center_services = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_services = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								//-------------------------------------------------------------end of input for table parameters-------------------------------------------------------------
								
								
								
								
								
								
								
								
								//----------------------------------------------execute insert query----------------------------------------------
								try{
									Statement st = conn.createStatement();
									int val = st.executeUpdate("INSERT INTO concenter VALUES('"+center_code+"','"+center_name+"','"+center_address+"','"+center_city+"','"+center_phone+"','"+center_email+"','"+center_services+"')");
									System.out.println("1 row affected");
									st.close();
								}catch(SQLException s){
									System.out.println("SQL statement is not executed!");
								}
								//----------------------------------------------------------------------------------------------------------------
								
								break;
								
								
								
							case 2://if [2]Conference Room(insert item menu) option is selected
								
								//--------initializing variables--------
								String room_code="";
								String room_name="";
								int room_maxCapacity=0;
								String room_eidosKathismatwn=""; 
								String room_ejoplismos = "";
								int room_wifi=0;
								double room_timh=0;
								int room_availability=0;
								center_code="";
								//--------------------------------------							
								
								
								
								//-------------------------------------------------------------getting input for table parameters-------------------------------------------------------------
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\nEnter conference room code: ");
										room_code = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_code = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference room name: ");
										room_name = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_name = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);

								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference room maximum capacity: ");
										room_maxCapacity = scanner.nextInt();
										scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_maxCapacity = 0;
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference room seat type: ");
										room_eidosKathismatwn = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_eidosKathismatwn = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference room equipment: ");
										room_ejoplismos = scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_ejoplismos = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nDoes conference room have WiFi?\n[0]No\n[1]Yes\nEnter your selection: ");
										room_wifi = scanner.nextInt();
										scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_services = "";
										flag = true;
									}
									if ((room_wifi!=0)&&(room_wifi!=1)) {
										System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
										flag=true;
									}
									else if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter conference room reservation price: ");
										room_timh = scanner.nextDouble();
										scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										center_address = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nIs the room available for reservation?\n[0]No\n[1]Yes\nEnter your selection: ");
										room_availability = scanner.nextInt();
										scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										room_availability = 0;
										flag = true;
									}
									if ((room_availability!=0)&&(room_availability!=1)) {
										System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
										flag=true;
									}
									else if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								try{
									Statement st = conn.createStatement();
									
									//--------------------------------------------------------Conference Center Catalog--------------------------------------------------------
									ResultSet res = st.executeQuery("SELECT * FROM concenter");
									System.out.print("\n\n");
									System.out.printf("%-15s %-15s %-20s %-15s %-12s %-25s %-20s%n", "Code", "Name", "Address", "City", "Phone", "Email", "Services");
									while (res.next()) {
										String i = res.getString("center_code");
										String s = res.getString("center_name");
										String r = res.getString("center_address");
										String t = res.getString("center_city");
										long y = res.getLong("center_phone");
										String u = res.getString("center_email");
										String z = res.getString("center_services");
										
										System.out.printf("%-15s %-15s %-20s %-15s %-12d %-25s %-20s%n",i,s,r,t,y,u,z);
									//-----------------------------------------------------------------------------------------------------------------------------------------
										
									}
								}catch(SQLException s){
										System.out.println("SQL code does not execute.");
								}
								
								do {//check the validity of input value
									flag=false;
									System.out.print("Enter code for conference center: ");
									center_code = scanner.nextLine();
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM concenter WHERE center_code='"+center_code+"'");
										if (!res.next()) {
											System.out.println("Error: Center code ["+center_code+"] not found in database!");
										}
										else {
											flag=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(flag==false);
								//-------------------------------------------------------------end of input for table parameters-------------------------------------------------------------
								
								
								
								
								
								

								//---------------------------------------------------------------execute insert query------------------------------------------------------------------------
								try{
									Statement st = conn.createStatement();
									int val = st.executeUpdate("INSERT INTO conroom VALUES('"+room_code+"','"+room_name+"','"+room_maxCapacity+"','"+room_eidosKathismatwn+"','"+
																room_ejoplismos+"','"+room_wifi+"','"+room_timh+"','"+room_availability+"','"+center_code+"')");
									System.out.println("1 row affected");
									st.close();
								}catch(SQLException s){
									System.out.println("SQL statement is not executed!");
								}
								//-----------------------------------------------------------------------------------------------------------------------------------------------------------
								
								break;
								
								
							case 3: //if [3]Customer option is selected
								
								//--------initializing table parameter variables--------
								String cus_onoma = "";
								String cus_email = "";
								long cus_phone = 0;
								//------------------------------------------------------
								
								
								
								
								//-------------------------------------------------------------getting input for table parameters-------------------------------------------------------------
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\nEnter customer name: ");
										cus_onoma = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										cus_onoma = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter customer email: ");
										cus_email = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										cus_email = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter customer phone: ");
										cus_phone = scanner.nextLong();
										scanner.nextLine();
										
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										cus_phone = 0;
										flag = true;
									}
									if ((flag==false)&&((String.valueOf(Math.abs(cus_phone)).length())!=10)) {
										System.out.print("Invalid input [Number must be exactly 10 digits!]\n");
										flag=true;
									}
									else if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								//------------------------------------------------------------------------------------------------------------------------------------------------------------
								
								
								
								
								
								
								
								//----------------------------------------------execute insert query----------------------------------------------
								try{
									Statement st = conn.createStatement();
									int val = st.executeUpdate("INSERT INTO customer VALUES('"+cus_onoma+"','"+cus_email+"','"+cus_phone+"')");
									System.out.println("1 row affected");
									st.close();
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL statement is not executed!");
								}
								//----------------------------------------------------------------------------------------------------------------
								
								break;
						
								
								
							case 4: //if [4]Back(insert item menu) option is selected
								flag_back = true;
								break;
									
						}
						
					}while(flag_back==false);
					
					break;
					
				case 2:	//if [2]Update Item(home menu) option is selected
					
					//--------initializing variables--------
					String col_name="";
					String newField = "";
					String name = "";
					flag_back=false;
					//--------------------------------------
					
					do {//do-while for going back and forth menus
						
						
						//----------------------------------table selection menu----------------------------------
						do { //check the validity of input value
							try {
								System.out.print("\n\n\n\n\n\n\n\n\n\nSelect table: \n[1]Conference Center\n[2]Conference Room\n[3]Customer\n[4]Back");
								System.out.print("\nEnter selection: ");
								select = scanner.nextInt();
								scanner.nextLine();
							}catch(Exception e) {
								e.printStackTrace();
								scanner.next();
								select = 0;
								flag = true;
							}
							if ((flag==false)&&((select<1)||(select>4))) {
								System.out.print("Invalid input [Enter numbers between 1 and 4]\n");
							}
							else if(flag){
								System.out.print("Invalid input\n");
							}
							flag=false;
						}while((select<1)||(select>4));
						//----------------------------------------------------------------------------------------
						
						
						switch(select) { //use switch for the options of tables to update
						
							case 1: //if [1]Conference Room(update item menu) option is selected
								
								String center_code="";
								
								try{
									Statement st = conn.createStatement();
									//--------------------------------------------------------Conference Center Catalog--------------------------------------------------------
									ResultSet res = st.executeQuery("SELECT * FROM concenter");
									System.out.print("\n\n");
									System.out.printf("%-15s %-15s %-20s %-15s %-12s %-25s %-20s%n", "Code", "Name", "Address", "City", "Phone", "Email", "Services");
									while (res.next()) {
										String i = res.getString("center_code");
										String s = res.getString("center_name");
										String r = res.getString("center_address");
										String t = res.getString("center_city");
										long y = res.getLong("center_phone");
										String u = res.getString("center_email");
										String z = res.getString("center_services");
										
										System.out.printf("%-15s %-15s %-20s %-15s %-12d %-25s %-20s%n",i,s,r,t,y,u,z);
									//-----------------------------------------------------------------------------------------------------------------------------------------
									}
								}catch(SQLException s){
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL code does not execute.");
								}						
								
								do {//check validity of value
									flag=false;
									System.out.print("Enter code for conference center: ");
									center_code = scanner.nextLine();
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM concenter WHERE center_code='"+center_code+"'");
										if (!res.next()) {
											System.out.println("Error: Center code ["+center_code+"] not found in database!");
										}
										else {
											flag=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(flag==false);
								
								
								flag = false;
								do { //check the validity of input value
									flag = false;
									try {
										System.out.print("\n\n\n\n\n\n\n\n\n\nSelect column: \n[1]Name\n[2]Address\n[3]City\n[4]Phone\n[5]Email\n[6]Services");
										System.out.print("\nEnter selection: ");
										select = scanner.nextInt();
										scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										select = 0;
										flag = true;
									}
									if ((flag==false)&&((select<1)||(select>6))) {
										System.out.print("Invalid input [Enter numbers between 1 and 6]\n");
									}
									else if(flag){
										System.out.print("Invalid input\n");
									}
									flag=false;
								}while((select<1)||(select>6));
								
								
								switch(select) { //use switch to put the column name into col_name to use it later on the query
								case 1:
									col_name = "center_name";
									break;
								case 2:
									col_name = "center_address";
									break;
								case 3: 
									col_name = "center_city";
									break;
								case 4:
									col_name = "center_phone";
									break;
								case 5:
									col_name = "center_email";
									break;
								case 6:
									col_name = "center_services";
									break;
								}
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter new value: ");
										newField = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										scanner.next();
										newField = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								//----------------------------------------------execute update query----------------------------------------------
								try{
								    Statement st = conn.createStatement();
								    st.executeUpdate("update concenter set "+col_name+"='"+newField+"' where center_code = '"+center_code+"'");
									System.out.println("1 row affected");
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL statement is not executed!");
								}
								//-----------------------------------------------------------------------------------------------------------------
								
								break;
								
							case 2: //if [2]Conference Room(update item menu) option is selected
								
								//------------initializing variables------------
								String room_code = "";
								col_name="";
								newField = "";
								//----------------------------------------------
								
								try {
								    Statement st = conn.createStatement();
								    //--------------------------------------------------------Conference Room Catalog--------------------------------------------------------
								    ResultSet res = st.executeQuery("SELECT * FROM conroom");
								    System.out.print("\n\n");
								    System.out.printf("%-10s %-20s %-12s %-20s %-20s %-10s %-10s %-15s%n", "Code", "Name", "Capacity", "Seat Type", "Equipment", "WiFi", "Price", "Available");
								    while (res.next()) {
								        String code = res.getString("room_code");
								        String r_name = res.getString("room_name");
								        int capacity = res.getInt("room_maxCapacity");
								        String seatType = res.getString("room_eidosKathismatwn");
								        String equipment = res.getString("room_ejoplismos");
								        String wifi = res.getInt("room_wifi") == 1 ? "Yes" : "No";
								        double price = res.getDouble("room_timh");
								        String available = res.getInt("room_availability") == 1 ? "Yes" : "No";
								        System.out.printf("%-10s %-20s %-12d %-20s %-20s %-10s %-10.2f %-15s%n", code, r_name, capacity, seatType, equipment, wifi, price, available);
								    }
								    //-----------------------------------------------------------------------------------------------------------------------------------------
								}catch(SQLException s) {
								    System.out.println("SQL code does not execute.");
								}


								do { //check validity of value
									flag=false;
									System.out.print("Enter code for conference room: ");
									room_code = scanner.nextLine();
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM conroom WHERE room_code='"+room_code+"'");
										if (!res.next()) {
											System.out.println("Error: Room code ["+room_code+"] not found in database!");
										}
										else {
											flag=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(flag==false);
								
								
								select=0;
								do { //check the validity of input value
									flag = false;
								    try {
								        System.out.print("\n\n\n\n\n\n\n\n\n\nSelect column:\n[1]Room Name\n[2]Max Capacity\n[3]Seat Type\n[4]Equipment\n[5]WiFi Available\n[6]Price\n[7]Availability");
								        System.out.print("\nEnter selection: ");
								        select = scanner.nextInt();
								        scanner.nextLine();
								    } catch(Exception e) {
								        select = 0;
								        flag = true;
								    }
								    if ((select<1)||(select>7)){
								        System.out.println("Invalid input [Enter numbers between 1 and 7]");
								    }
								    else if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag&&(select<1)||(select>7));
								
								col_name = "";
								switch(select) { //use switch to put column name into col_name to use in query later
								    case 1:
								    	col_name = "room_name";
								        break;
								    case 2:
								    	col_name = "room_maxCapacity";
								        break;
								    case 3: 
								    	col_name = "room_eidosKathismatwn";
								        break;
								    case 4:
								    	col_name = "room_ejoplismos";
								        break;
								    case 5:
								    	col_name = "room_wifi";
								        break;
								    case 6:
								    	col_name = "room_timh";
								        break;
								    case 7:
								    	col_name = "room_availability";
								        break;
								}
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter new value: ");
										newField = scanner.nextLine();
									}catch(Exception e) {
										e.printStackTrace();
										newField = "";
										flag = true;
									}
									if(flag){
										System.out.print("Invalid input\n");
									}
								}while(flag);
								
								//----------------------------------------------execute update query----------------------------------------------
								try{
								    Statement st = conn.createStatement();
								    st.executeUpdate("update conroom set "+col_name+"='"+newField+"' where room_code = '"+room_code+"'");
									System.out.println("1 row affected");
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL statement is not executed!");
								}
								//----------------------------------------------------------------------------------------------------------------
								
								break;
								
							case 3: //if [3]Customer (update item menu) option is selected
								
								String cus_name = "";
								try {
									Statement st = conn.createStatement();
									//--------------------------------------------------------Customer Catalog--------------------------------------------------------
									ResultSet res = st.executeQuery("SELECT * FROM customer");
									System.out.print("\n\n");
									System.out.printf("%-30s %-30s %-15s%n", "Name", "Email", "Phone");
									while (res.next()) {
										name = res.getString("cus_onoma");
										String email = res.getString("cus_email");
										long phone = res.getLong("cus_phone");
										
										System.out.printf("%-30s %-30s %-15d%n", name, email, phone);
										//-----------------------------------------------------------------------------------------------------------------------------------------
									}
								} catch(SQLException s) {
									System.out.println("SQL code does not execute.");
								}
								
								flag=false;
								do { //check validity of input value
									flag=false;
									System.out.print("Enter name for customer to update: ");
									cus_name = scanner.nextLine();
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM customer WHERE cus_onoma='"+cus_name+"'");
										if (!res.next()) {
											System.out.println("Error: Customer Name ["+cus_name+"] not found in database!");
										}
										else {
											flag=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(flag==false);
								
								
								flag = false;
								do { //check the validity of input value
									flag = false;
									try {
										System.out.print("\n\n\n\n\n\n\n\n\n\nSelect column to update: \n[1]Email\n[2]Phone");
										System.out.print("\nEnter selection: ");
										select = scanner.nextInt();
										scanner.nextLine();
									} catch(Exception e) {
										e.printStackTrace();
										select = 0;
										flag = true;
									}
									if ((flag==false)&&((select<1)||(select>2))) {
										System.out.print("Invalid input [Enter numbers between 1 and 2]\n");
									}
									else if(flag) {
										System.out.print("Invalid input\n");
									}
									flag=false;
								} while((select<1)||(select>2));
								
								switch(select) { //use switch to put column name into col_name to use in query later
								case 1:
									col_name = "cus_email";
									break;
								case 2:
									col_name = "cus_phone";
									break;
								}
								
								flag=false; //use for error message
								do { //check the validity of input value
									flag=false;
									try {
										System.out.print("\nEnter new value: ");
										newField = scanner.nextLine();
										
										// Additional validation for phone number
										if (col_name.equals("cus_phone")) {
											if (newField.length() != 10 || !newField.matches("\\d+")) {
												System.out.print("Invalid input [Phone must be exactly 10 digits!]\n");
												flag = true;
												continue;
											}
										}
									} catch(Exception e) {
										e.printStackTrace();
										newField = "";
										flag = true;
									}
								} while(flag);
								
								
								//----------------------------------------------execute update query----------------------------------------------
								try{
									Statement st = conn.createStatement();
									st.executeUpdate("update customer set "+col_name+"='"+newField+"' where cus_onoma = '"+cus_name+"'");
									System.out.println("1 row affected");
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL statement is not executed!");
								}
								//----------------------------------------------------------------------------------------------------------------
								
								break;
							case 4:
								flag_back=true;
								break;
							}
					}while(flag_back==false);
					break;
					
					
				case 3: //if [3]Get Item (home menu) option is selected
					
					//---------initialize variables---------
					String center_code="";
					String any_key="asdasdasd"; //for the user to be able to view the items we choses for as long as he wants. He expect any key to continiue and we store it in this variable
					//--------------------------------------
					
					do {//do-while for being able to go back and forth menus
						
						//----------------------------------table selection menu----------------------------------
						do { //check the validity of input value
							try {
								System.out.print("\n\n\n\n\n\n\n\n\n\nSelect list to view: \n[1]View all conference rooms of a center\n[2]View all reserved conference rooms"
										+ "\n[3]View all conference rooms with pending reservations\n[4]View conference rooms by filters\n[5]Back");
								System.out.print("\nEnter selection: ");
								select = scanner.nextInt();
								scanner.nextLine();
							}catch(Exception e) {
								e.printStackTrace();
								select = 0;
								flag = true;
							}
							if ((flag==false)&&((select<1)||(select>5))) {
								System.out.print("Invalid input [Enter numbers between 1 and 5]\n");
							}
							else if(flag){
								System.out.print("Invalid input\n");
							}
							flag=false;
						}while((select<1)||(select>5));
						//----------------------------------------------------------------------------------------
						
						flag_back = false;
						switch(select){ //use switch for each option for get item 
						
							case 1: //if [1]View all conference rooms of a center (Get Item menu) option is selected
								
								try{
									Statement st = conn.createStatement();
									//--------------------------------------------------------Conference Center Catalog--------------------------------------------------------
									ResultSet res = st.executeQuery("SELECT * FROM concenter");
									System.out.print("\n\n");
									System.out.printf("%-15s %-15s %-20s %-15s %-12s %-25s %-20s%n", "Code", "Name", "Address", "City", "Phone", "Email", "Services");
									while (res.next()) {
										String i = res.getString("center_code");
										String s = res.getString("center_name");
										String r = res.getString("center_address");
										String t = res.getString("center_city");
										long y = res.getLong("center_phone");
										String u = res.getString("center_email");
										String z = res.getString("center_services");
										
										System.out.printf("%-15s %-15s %-20s %-15s %-12d %-25s %-20s%n",i,s,r,t,y,u,z);
									//-----------------------------------------------------------------------------------------------------------------------------------------
									}
								}catch(SQLException s){
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL code does not execute.");
								}
								
								
								do { //check validity of input value
									flag=false;
									System.out.print("Enter code for conference center: ");
									center_code = scanner.nextLine();
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM concenter WHERE center_code='"+center_code+"'");
										if (!res.next()) {
											System.out.println("Error: Center code ["+center_code+"] not found in database!");
										}
										else {
											flag=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(flag==false);
								
								
								try {
								    Statement st = conn.createStatement();
								    //--------------------------------------------------------Conference Room Catalog--------------------------------------------------------
								    ResultSet res = st.executeQuery("SELECT * FROM conroom WHERE center_code='"+center_code+"'");
								    System.out.print("\n\n");
								    System.out.printf("%-10s %-20s %-12s %-20s %-20s %-10s %-10s %-15s %-15s%n", "Code", "Name", "Capacity", "Seat Type", "Equipment", "WiFi", "Price", "Available", "Center Code");
								    while (res.next()) {
								        String code = res.getString("room_code");
								        String r_name = res.getString("room_name");
								        int capacity = res.getInt("room_maxCapacity");
								        String seatType = res.getString("room_eidosKathismatwn");
								        String equipment = res.getString("room_ejoplismos");
								        String wifi = res.getInt("room_wifi") == 1 ? "Yes" : "No";
								        double price = res.getDouble("room_timh");
								        String available = res.getInt("room_availability") == 1 ? "Yes" : "No";
								        String centerCode = res.getString("center_code");
								        System.out.printf("%-10s %-20s %-12d %-20s %-20s %-10s %-10.2f %-15s %-15s%n", code, r_name, capacity, seatType, equipment, wifi, price, available, centerCode);
								    }
								    //-----------------------------------------------------------------------------------------------------------------------------------------
								}catch(SQLException s) {
								    System.out.println("SQL code does not execute.");
								}
								System.out.print("Enter any key to continue: ");
								any_key = scanner.nextLine();
								
								break;
								
							case 2: //if [2]View all reserved conference rooms (Get Item menu) option is selected
								String query="";
								String code = null;
								List<String> codeList = new ArrayList<>(); //use arraylist to store all room_code codes that have reservations linked to them
								try {
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery("SELECT room_code FROM reservesion");
									while (res.next()) {
										flag =false;
										code = res.getString("room_code");
										for (String i : codeList) {
											if (i.equals(code)) {
												flag = true;
												break;
											}
										}
										if (flag==false) {
											codeList.add(code);
										}
									}
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL code does not execute.");
								}
								
								//use a loop to construct the select query that is used below to print the table of reserved rooms
								query="SELECT * FROM conroom WHERE ";
								for (String i : codeList) {
									if (i.equals(codeList.get(0))) {
										query = query+" room_code='"+i+"'";
									}
									else {
										query = query+"or room_code='"+i+"'";
									}
								}
								
								try{
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery(query);
									//--------------------------------------------------------Reserved Conference Room Catalog--------------------------------------------------------
									System.out.print("\n\n");
								    System.out.printf("%-10s %-20s %-12s %-20s %-20s %-10s %-10s %-15s %-15s%n", "Code", "Name", "Capacity", "Seat Type", "Equipment", "WiFi", "Price", "Available", "Center Code");
								    while (res.next()) {
								        code = res.getString("room_code");
								        String r_name = res.getString("room_name");
								        int capacity = res.getInt("room_maxCapacity");
								        String seatType = res.getString("room_eidosKathismatwn");
								        String equipment = res.getString("room_ejoplismos");
								        String wifi = res.getInt("room_wifi") == 1 ? "Yes" : "No";
								        double price = res.getDouble("room_timh");
								        String available = res.getInt("room_availability") == 1 ? "Yes" : "No";
								        String centerCode = res.getString("center_code");
								        System.out.printf("%-10s %-20s %-12d %-20s %-20s %-10s %-10.2f %-15s %-15s%n", code, r_name, capacity, seatType, equipment, wifi, price, available, centerCode);
								    }
								    //---------------------------------------------------------------------------------------------------------------------------------------------------
								}catch(SQLException s){
									System.out.println("SQL code does not execute.");
								}
								System.out.print("Enter any key to continue: ");
								any_key = scanner.nextLine();
								break;
								
							case 3: //if [3]View all conference rooms with pending reservations (Get Item menu) option is selected
								
								query="";
								code = null;
								codeList = new ArrayList<>(); //use the same technique with [2]View all reserved conference rooms using array list to store all room codes with 'pending' payment rows linked to them
								int pay_code=0;
								try {
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery("SELECT room_code, pay_code FROM reservesion");
									while (res.next()) {
										
										flag =false;
										code = res.getString("room_code");
										pay_code = res.getInt("pay_code");
										
										for (String i : codeList) {
											if (i.equals(code)) {
												flag = true;
												break;
											}
										}
										
										if (flag==false) {
											try {
												Statement st_status = conn.createStatement();
												ResultSet res_status = st_status.executeQuery("SELECT pay_katastash FROM payment WHERE pay_code='"+pay_code+"'");
												res_status.next();
												if (res_status.getString("pay_katastash").equals("pending")) {
													codeList.add(code);
												}
											}catch(SQLException s){
												System.out.println("SQL Error: " + s.getMessage());
												System.out.println("SQL code does not execute.");
											}
										}
										
									}
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL code does not execute.");
								}
								
								//use loop to construct the select query used for printing the table
								query="SELECT * FROM conroom WHERE ";
								for (String i : codeList) {
									if (i.equals(codeList.get(0))) {
										query = query+" room_code='"+i+"'";
									}
									else {
										query = query+"or room_code='"+i+"'";
									}
								}

								try{
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery(query);
									//--------------------------------------------------------Pending Payment-Reserved Conference Room Catalog--------------------------------------------------------
									System.out.print("\n\n");
								    System.out.printf("%-10s %-20s %-12s %-20s %-20s %-10s %-10s %-15s %-15s%n", "Code", "Name", "Capacity", "Seat Type", "Equipment", "WiFi", "Price", "Available", "Center Code");
								    while (res.next()) {
								        code = res.getString("room_code");
								        String r_name = res.getString("room_name");
								        int capacity = res.getInt("room_maxCapacity");
								        String seatType = res.getString("room_eidosKathismatwn");
								        String equipment = res.getString("room_ejoplismos");
								        String wifi = res.getInt("room_wifi") == 1 ? "Yes" : "No";
								        double price = res.getDouble("room_timh");
								        String available = res.getInt("room_availability") == 1 ? "Yes" : "No";
								        String centerCode = res.getString("center_code");
								        System.out.printf("%-10s %-20s %-12d %-20s %-20s %-10s %-10.2f %-15s %-15s%n", code, r_name, capacity, seatType, equipment, wifi, price, available, centerCode);
								    }
								  //----------------------------------------------------------------------------------------------------------------------------------------------------------------
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL code does not execute.");		
								}
								
								System.out.print("Enter any key to continue: ");
								any_key = scanner.nextLine();
								
								break;
								
							case 4: //if [4]View conference rooms by filters (Get Item menu) option is selected
								
								//---------initialize variables---------
								int count = 0;
								boolean flag_back2 = false;
								query="SELECT * FROM conroom WHERE ";
								int maxCap=-1;
								String seat_type = "";
								int room_wifi = 0;
								double maxPrice = 0;
								double minPrice = 0;
								//--------------------------------------
								
								do {//use do-while loop to go back and forth menus
									
									do { //check the validity of input value
										try {
											System.out.print("\n\n\n\n\n\n\n\n\n\nSelect filters to add: \n[1]Max Capacity\n[2]Seat Type\n[3]WiFi Available\n[4]Maximum Price\n[5]Minimum Price\n[6]Done");
											System.out.print("\nEnter selection: ");
											select = scanner.nextInt();
											scanner.nextLine();
										}catch(Exception e) {
											e.printStackTrace();
											scanner.next();
											select = 0;
											flag = true;
										}
										if ((flag==false)&&((select<1)||(select>6))) {
											System.out.print("Invalid input [Enter numbers between 1 and 6]\n");
										}
										else if(flag){
											System.out.print("Invalid input\n");
										}
										flag=false;
									}while((select<1)||(select>6));
									
									
									count+=1;
									switch(select) { //use switch for each filter the user choses to apply
										case 1:
											flag=false; //use for error message
											do { //check the validity of input value
												flag=false;
												try {
													System.out.print("\nEnter maximum capacity: ");
													maxCap = scanner.nextInt();
													scanner.nextLine();
												} catch(Exception e) {
													e.printStackTrace();
													scanner.next();
													maxCap = -1;
													flag = true;
												}
												if(flag) {
													System.out.print("Invalid input\n");
												}
											} while(flag);
											if (count==1) {
												query = query + "room_maxCapacity='"+maxCap+"'";
											}
											else {
												query = query + "and room_maxCapacity='"+maxCap+"'";
											}
											break;
										case 2:
											flag=false; //use for error message
											do { //check the validity of input value
												flag=false;
												try {
													System.out.print("\nEnter seat type: ");
													seat_type = scanner.nextLine();
												} catch(Exception e) {
													e.printStackTrace();
													scanner.next();
													seat_type = "";
													flag = true;
												}
												if(flag) {
													System.out.print("Invalid input\n");
												}
											} while(flag);
											if (count==1) {
												query = query + "room_eidosKathismatwn='"+seat_type+"'";
											}
											else {
												query = query + "and room_eidosKathismatwn='"+seat_type+"'";
											}
											break;
										case 3:
											flag=false; //use for error message
											do { //check the validity of input value
												flag=false;
												try {
													System.out.print("\nDoes conference room have WiFi?\n[0]No\n[1]Yes\nEnter your selection: ");
													room_wifi = scanner.nextInt();
													scanner.nextLine();
												}catch(Exception e) {
													e.printStackTrace();
													scanner.next();
													room_wifi = 0;
													flag = true;
												}
												if ((room_wifi!=0)&&(room_wifi!=1)) {
													System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
													flag=true;
												}
												else if(flag){
													System.out.print("Invalid input\n");
												}
											}while(flag);
											if (count==1) {
												query = query + "room_wifi='"+room_wifi+"'";
											}
											else {
												query = query + "and room_wifi='"+room_wifi+"'";
											}
											break;
										case 4:
											flag=false; //use for error message
											do { //check the validity of input value
												flag=false;
												try {
													System.out.print("\nEnter maximum price: ");
													maxPrice = scanner.nextDouble();
													scanner.nextLine();
												} catch(Exception e) {
													e.printStackTrace();
													scanner.next();
													maxPrice = 0;
													flag = true;
												}
												if(flag) {
													System.out.print("Invalid input\n");
												}
											} while(flag);
											if (count==1) {
												query = query + "room_timh<='"+maxPrice+"'";
											}
											else {
												query = query + "and room_timh<='"+maxPrice+"'";
											}
											break;
										case 5:
											flag=false; //use for error message
											do { //check the validity of input value
												flag=false;
												try {
													System.out.print("\nEnter minimum price: ");
													minPrice = scanner.nextDouble();
													scanner.nextLine();
												} catch(Exception e) {
													e.printStackTrace();
													scanner.next();
													minPrice = 0;
													flag = true;
												}
												if(flag) {
													System.out.print("Invalid input\n");
												}
											} while(flag);
											if (count==1) {
												query = query + "room_timh>='"+minPrice+"'";
											}
											else {
												query = query + "and room_timh>='"+minPrice+"'";
											}
											break;
										case 6:
											flag_back2 = true;
											break;
										}
								}while(flag_back2==false);
								
								try{
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery(query);
									//--------------------------------------------------------Conference Room Filtered Catalog--------------------------------------------------------
									System.out.print("\n\n");
								    System.out.printf("%-10s %-20s %-12s %-20s %-20s %-10s %-10s %-15s %-15s%n", "Code", "Name", "Capacity", "Seat Type", "Equipment", "WiFi", "Price", "Available", "Center Code");
								    while (res.next()) {
								        code = res.getString("room_code");
								        String r_name = res.getString("room_name");
								        int capacity = res.getInt("room_maxCapacity");
								        String seatType = res.getString("room_eidosKathismatwn");
								        String equipment = res.getString("room_ejoplismos");
								        String wifi = res.getInt("room_wifi") == 1 ? "Yes" : "No";
								        double price = res.getDouble("room_timh");
								        String available = res.getInt("room_availability") == 1 ? "Yes" : "No";
								        String centerCode = res.getString("center_code");
								        System.out.printf("%-10s %-20s %-12d %-20s %-20s %-10s %-10.2f %-15s %-15s%n", code, r_name, capacity, seatType, equipment, wifi, price, available, centerCode);
								    }
								    //-------------------------------------------------------------------------------------------------------------------------------------------------
								}catch(SQLException s){
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL code does not execute.");
								}
								
								System.out.print("Enter any key to continue: ");
								any_key = scanner.nextLine();
								
								break;
								
							case 5: //if [5]Back (Get Item menu) option is selected
								flag_back=true;
								break;
							}
					}while(flag_back==false);
					break;
					
				case 4: //if [4]Reservations (home menu) option is selected
					
					col_name="";
					flag_back=false;
					
					do { //use do-while loop to go back and forth menus
						
							//----------------------------------table selection menu----------------------------------
							do { //check the validity of input value
								try {
									System.out.print("\n\n\n\n\n\n\n\n\n\nSelect action: \n[1]Reserve Room\n[2]Pay Reservation\n[3]Cancel Reservation\n[4]Update Reservation\n[5]Update Payment\n[6]View/Delete canceled reservations\n[7]Back");
									System.out.print("\nEnter selection: ");
									select = scanner.nextInt();
									scanner.nextLine();
								}catch(Exception e) {
									e.printStackTrace();
									select = 0;
									flag = true;
								}
								if ((flag==false)&&((select<1)||(select>7))) {
									System.out.print("Invalid input [Enter numbers between 1 and 7]\n");
								}
								else if(flag){
									System.out.print("Invalid input\n");
								}
								flag=false;
							}while((select<1)||(select>7));
							//----------------------------------------------------------------------------------------
						
					switch(select) {	
					
						case 1: //if [1]Reserve Room (Reservations menu) option is selected
							
							//--------initializing table parameter variables--------
							String res_code="";
							String res_city="";
							String res_hmerominia="";
							int res_summetexontes = 0;
							String res_protimiseisEjoplismou = "";
							int res_timologio=0;
							String room_code="";
							String cus_onoma="";
							center_code ="";
							double price = 0;
							int pay_code=0;
							//------------------------------------------------------	
							
							//-------------------------------------------------------------getting input for table parameters-------------------------------------------------------------
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\nEnter reservation code: ");
									res_code = scanner.nextLine();
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									res_code = "";
									flag = true;
								}
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nEnter reservation city: ");
									res_city = scanner.nextLine();
									
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									res_city = "";
									flag = true;
								}
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							//use java libraries to ensure the date input is in correct format and stored in database correctly so that date comparison is easy
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); //create a date format (same as database accepts)
							LocalDate reservationDate = null;
							while (true) { //use loop to check validity of input value
							    try {
							        System.out.print("\nEnter reservation date (YYYY-MM-DD): ");
							        String input = scanner.nextLine().trim();

							        reservationDate = LocalDate.parse(input, formatter);

							        if (reservationDate.isBefore(LocalDate.now())) { //also check if date is in the past or not
							            System.out.println("Error: Date is in the past.");
							            continue;
							        }
							        break; // valid date
							    } catch (DateTimeParseException e) {
							        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
							    }
							}
							res_hmerominia = reservationDate.toString(); //convert to string so we can pass it to the database though the query
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									
									Statement st = conn.createStatement();    
							        ResultSet res = st.executeQuery("SELECT * FROM concenter");
							        System.out.print("\n\n");
							        
							        //--------------------------------------------------------Conference Center Catalog--------------------------------------------------------
							        System.out.printf("%-12s %-25s %-30s %-15s %-15s %-25s %-30s%n", "Code", "Name", "Address", "City", "Phone", "Email", "Services");
							        while (res.next()) {
							            String code = res.getString("center_code");
							            name = res.getString("center_name");
							            String address = res.getString("center_address");
							            String city = res.getString("center_city");
							            long phone = res.getLong("center_phone");
							            String email = res.getString("center_email");
							            String services = res.getString("center_services");
							            
							            System.out.printf("%-12s %-25s %-30s %-15s %-15s %-25s %-30s%n", code, name, address, city, phone, email, services);
							        }
							        //-----------------------------------------------------------------------------------------------------------------------------------------
							        res.close();
							        st.close();
								}catch(Exception e) {
									e.printStackTrace();
									flag = true;
								}
								
								//check is input center code exists in database
								boolean valid=false;
								do {
									valid=false;
									System.out.print("\nEnter code for conference center: ");
									center_code = scanner.nextLine();
									try {
										Statement st1 = conn.createStatement();
										ResultSet res1 = st1.executeQuery("SELECT * FROM concenter WHERE center_code='"+center_code+"'");
										if (!res1.next()) {
											System.out.println("Error: Center code ["+center_code+"] not found in database!");
										}
										else {
											valid=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(valid==false);
									
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									
									//--------------------------------------------------------Conference Room Catalog--------------------------------------------------------
									Statement st = conn.createStatement();	
									ResultSet res = st.executeQuery("SELECT * FROM `conroom` WHERE center_code='"+center_code+"'");
									System.out.print("\n\n");
									System.out.printf("%-12s %-20s %-12s %-15s %-15s %-15s %-10s %-15s %-20s%n", "Code", "Name", "Max Capacity", "Seat Type", "Equipment", "WiFi Available", "Price", "Room Available", "Conference Center Code");
									while (res.next()) {
										String i = res.getString("room_code");
										String s = res.getString("room_name");
										int r = res.getInt("room_maxCapacity");
										String t = res.getString("room_eidosKathismatwn");
										String y = res.getString("room_ejoplismos");
										String u = res.getInt("room_wifi") == 1 ? "Yes" : "No";
										double z = res.getDouble("room_timh");
										String x = res.getInt("room_availability") == 1 ? "Yes" : "No";
										String c = res.getString("center_code");
										
										System.out.printf("%-12s %-20s %-12d %-15s %-15s %-15s %-10.2f %-15s %-20s%n",i, s, r, t, y, u, z, x, c);
									}
									//-----------------------------------------------------------------------------------------------------------------------------------------
								}catch(Exception e) {
									e.printStackTrace();
									flag = true;
								}
								
								//check is input center code exists in database
								boolean valid=false;
								do {
									valid=false;
									System.out.print("\nEnter code for conference room: ");
									room_code = scanner.nextLine();
									try {
										Statement st1 = conn.createStatement();
										ResultSet res1 = st1.executeQuery("SELECT * FROM conroom WHERE room_code='"+room_code+"'");
										if (!res1.next()) {
											System.out.println("Error: Room code ["+room_code+"] not found in database!");
										}
										else {
											valid=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(valid==false);
	
									
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nEnter participants: ");
									res_summetexontes = scanner.nextInt();
									scanner.nextLine();
									
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									res_summetexontes = 0;
									flag = true;
								}
								if ((flag==false)&&((String.valueOf(Math.abs(res_summetexontes)).length())>10)) {
									System.out.print("Invalid input [Number must not be longer than 10 digits!]\n");
									flag=true;
								}
								try {
									Statement st = conn.createStatement();		
									ResultSet res = st.executeQuery("SELECT room_maxCapacity FROM conroom WHERE room_code='"+room_code+"'");
									if (res.next()) {
										if (res_summetexontes>res.getInt("room_maxCapacity")) {
											System.out.println("Invalid input [Participants can not be more than the maximum capacity!]");
											System.out.print("Maximum capacity of room ["+room_code+"]: "+res.getString("room_maxCapacity")+" participants");
											flag = true;
										}
									}
									else {
										System.out.println("Error: Room code [" + room_code + "] not found in database!");
										flag = true;										
									}
									res.close(); //close resultSet
								    st.close(); //close statement
								}catch(SQLException s){
									System.out.println("SQL code does not execute.");
									System.out.println("SQL Error: " + s.getMessage());
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nEnter equipment preferences: ");
									res_protimiseisEjoplismou = scanner.nextLine();
									
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									res_protimiseisEjoplismou = "";
									flag = true;
								}
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nAre invoices an option?\n[0]No\n[1]Yes\nEnter your selection: ");
									res_timologio = scanner.nextInt();
									scanner.nextLine();
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									res_timologio = 0;
									flag = true;
								}
								if ((res_timologio!=0)&&(res_timologio!=1)) {
									System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
									flag=true;
								}
								else if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									
									//--------------------------------------------------------Customer Catalog--------------------------------------------------------
							        Statement st = conn.createStatement();    
							        ResultSet res = st.executeQuery("SELECT cus_onoma, cus_email, cus_phone FROM customer");
							        System.out.print("\n\n");
							        System.out.printf("%-30s %-30s %-15s%n", "Name", "Email", "Phone");		        
							        while (res.next()) {
							            name = res.getString("cus_onoma");
							            String email = res.getString("cus_email");
							            long phone = res.getLong("cus_phone");
							            
							            System.out.printf("%-30s %-30s %-15s%n", name, email, phone);
							        }
							        //-----------------------------------------------------------------------------------------------------------------------------------------
							        
							        boolean valid=false;
									do {
										valid=false;
										System.out.print("\nEnter customer name: ");
										cus_onoma = scanner.nextLine();
										try {
											Statement st1 = conn.createStatement();
											ResultSet res1 = st1.executeQuery("SELECT * FROM customer WHERE cus_onoma='"+cus_onoma+"'");
											if (!res1.next()) {
												System.out.println("Error: Customer Name ["+cus_onoma+"] not found in database!");
											}
											else {
												valid=true;
											}
										}catch(SQLException s){
											System.out.println("SQL code does not execute.");
										}
									}while(valid==false);
									
								}catch(Exception e) {
									e.printStackTrace();
									cus_onoma = "";
									flag = true;
								}
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							//----------------------------------------------execute insert query for reservation----------------------------------------------
							try{
								Statement st = conn.createStatement();
								int val = st.executeUpdate("INSERT INTO reservesion VALUES('"+res_code+"','"+res_city+"','"+res_hmerominia+"','"+res_summetexontes+"','"+res_protimiseisEjoplismou+"',"
										+ "'"+res_timologio+"','0','"+room_code+"','"+cus_onoma+"','"+center_code+"',NULL)");
								System.out.println("1 row affected");
								st.close();
							}catch(SQLException s){
								System.out.println("SQL Error: " + s.getMessage());
								System.out.println("SQL statement is not executed!");
							}
							//--------------------------------------------------------------------------------------------------------------------------------
							
							//----------------------------------------------execute insert query for payment----------------------------------------------
							try{
								Statement st = conn.createStatement();
								ResultSet res = st.executeQuery("SELECT room_timh FROM conroom WHERE room_code='"+room_code+"'");
								if(res.next()) {
									price = res.getDouble("room_timh");
								}
								int val = st.executeUpdate("INSERT INTO payment (pay_poso,pay_katastash, res_code, cus_onoma) VALUES ('"+price+"','pending','"+res_code+"','"+cus_onoma+"')");
								System.out.println("1 row affected");
								st.close();
							}catch(SQLException s){
								System.out.println("SQL Error: " + s.getMessage());
								System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							
							//----------------------------------------------execute update query for reservation----------------------------------------------
							try{
								Statement st = conn.createStatement();
								ResultSet res = st.executeQuery("SELECT pay_code FROM payment WHERE res_code='"+res_code+"'");
								if(res.next()) {
									pay_code = res.getInt("pay_code");
								}
								st.executeUpdate("update reservesion set pay_code='"+pay_code+"' where res_code = '"+res_code+"'");
								System.out.println("1 row affected");
								st.close();
							}catch(SQLException s){
								System.out.println("SQL Error: " + s.getMessage());
								System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							
							break;
							
							
							
						case 2: //if [2]Pay Reservation(Reservations menu) option is selected
							
							//--------initializing variables--------
							pay_code = 0;
							int temp = 0;
							String pay_methodos = "";
							//--------------------------------------
							
							//-------------------------------------------------------------getting input for table parameters-------------------------------------------------------------
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									
									//--------------------------------------------------------Pending Payments Catalog--------------------------------------------------------
									Statement st = conn.createStatement();    
									ResultSet res = st.executeQuery("SELECT pay_code, pay_poso, pay_katastash, res_code, cus_onoma FROM payment WHERE pay_katastash='pending'");
									System.out.print("\n\n");
									System.out.printf("%-10s %-10s %-12s %-15s %-20s%n", "Pay Code", "Amount", "Status", "Res Code", "Customer");
									while (res.next()) {
									    int payCode = res.getInt("pay_code");
									    double amount = res.getDouble("pay_poso");
									    String status = res.getString("pay_katastash");
									    String resCode = res.getString("res_code");
									    String customerName = res.getString("cus_onoma");
									    System.out.printf("%-10d %-10.2f %-12s %-15s %-20s%n", payCode, amount, status, resCode, customerName);
									}
									//-----------------------------------------------------------------------------------------------------------------------------------------
									
									
								}catch(Exception e) {
									e.printStackTrace();
									flag = true;
								}
								
								
								//check if input pay_code exists in database
								boolean valid=false;
								do {
									System.out.print("\nEnter pending payment code: ");
									pay_code = scanner.nextInt();
									try {
										Statement st1 = conn.createStatement();
										ResultSet res1 = st1.executeQuery("SELECT * FROM payment WHERE pay_code='"+pay_code+"'");
										if (!res1.next()) {
											System.out.println("Error: Payment Code ["+pay_code+"] not found in database!");
										}
										else {
											valid=true;
										}
									}catch(SQLException s){
										System.out.println("SQL code does not execute.");
									}
								}while(valid==false);
								
								if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nSelect payment method?\n[0]Cash\n[1]Card\nEnter your selection: ");
									temp = scanner.nextInt();
									scanner.nextLine();
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									temp = 0;
									flag = true;
								}
								if ((temp!=0)&&(temp!=1)) {
									System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
									flag=true;
								}
								else if(flag){
									System.out.print("Invalid input\n");
								}
								if (temp==1) {
									pay_methodos = "Card";
								}
								else {
									pay_methodos = "Cash";
								}
							}while(flag);
							//------------------------------------------------------------------------------------------------------------------------------------------------------------
							
							
							//----------------------------------------------execute insert query for payment----------------------------------------------
							try{
							    Statement st = conn.createStatement();
							    st.executeUpdate("update payment set pay_methodos = '"+pay_methodos+"', pay_katastash='completed', pay_hmeromhnia=NOW() where pay_code = "+pay_code);
								System.out.println("1 row affected");
							}catch(SQLException s){
								System.out.println("SQL Error: " + s.getMessage());
								System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							
							
							break;
							
						case 3: // if [3]Cancel Reservation (Reservations menu) option is selected
							
							try {
							    Statement st = conn.createStatement();
							    //--------------------------------------------------------Reservation Catalog--------------------------------------------------------
							    ResultSet res = st.executeQuery("SELECT * FROM reservesion");
							    System.out.print("\n\n");
							    System.out.printf("%-15s %-15s %-15s %-10s %-20s %-10s %-10s %-15s %-15s %-15s%n", "Res Code", "City", "Date", "Participants", "Equipment Pref", "Invoice", "Canceled", "Room Code", "Customer", "Center Code");
							    while (res.next()) {
							        String code = res.getString("res_code");
							        String city = res.getString("res_resCity");
							        String date = res.getString("res_hmerominia");
							        int participants = res.getInt("res_summetexontes");
							        String equipment = res.getString("res_protimiseisEjoplismou");
							        int invoice = res.getInt("res_timologio");
							        String cancel = res.getInt("res_akurosi") == 1 ? "Yes" : "No";
							        String room = res.getString("room_code");
							        String customer = res.getString("cus_onoma");
							        String center = res.getString("center_code");
							        
							        System.out.printf("%-15s %-15s %-15s %-10d %-20s %-10d %-10s %-15s %-15s %-15s%n", code, city, date, participants, equipment, invoice, cancel, room, customer, center);
							    }
							    //-----------------------------------------------------------------------------------------------------------------------------------------
							} catch(SQLException s) {
								System.out.println("SQL Error: " + s.getMessage());
							    System.out.println("SQL code does not execute.");
							}
							
							boolean valid=false;
							do {
								valid=false;
								System.out.print("\nEnter reservation code to cancel: ");
								res_code = scanner.nextLine();
								try {
									Statement st1 = conn.createStatement();
									ResultSet res1 = st1.executeQuery("SELECT * FROM reservesion WHERE res_code='"+res_code+"'");
									if (!res1.next()) {
										System.out.println("Error: Reservation code ["+res_code+"] not found in database!");
									}
									else {
										valid=true;
									}
								}catch(SQLException s){
									System.out.println("SQL code does not execute.");
								}
							}while(valid==false);
							
							
							//----------------------------------------------execute insert query for payment----------------------------------------------
							try{
							    Statement st = conn.createStatement();
							    st.executeUpdate("update reservesion set res_akurosi = 1 where res_code = '"+res_code+"'");
								System.out.println("1 row affected");
							}catch(SQLException s){
								System.out.println("SQL Error: " + s.getMessage());
								System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							
							break;
							
						case 4: // if [4]Update Reservation (Reservations menu) option is selected
							
							res_code = "";
							try {
							    Statement st = conn.createStatement();
							    //--------------------------------------------------------Reservation Catalog--------------------------------------------------------
							    ResultSet res = st.executeQuery("SELECT * FROM reservesion");
							    System.out.print("\n\n");
							    System.out.printf("%-15s %-15s %-15s %-10s %-20s %-10s %-10s %-15s %-15s %-15s%n", "Res Code", "City", "Date", "Participants", "Equipment Pref", "Invoice", "Canceled", "Room Code", "Customer", "Center Code");
							    while (res.next()) {
							        String code = res.getString("res_code");
							        String city = res.getString("res_resCity");
							        String date = res.getString("res_hmerominia");
							        int participants = res.getInt("res_summetexontes");
							        String equipment = res.getString("res_protimiseisEjoplismou");
							        int invoice = res.getInt("res_timologio");
							        String cancel = res.getInt("res_akurosi") == 1 ? "Yes" : "No";
							        String room = res.getString("room_code");
							        String customer = res.getString("cus_onoma");
							        String center = res.getString("center_code");
							        
							        System.out.printf("%-15s %-15s %-15s %-10d %-20s %-10d %-10s %-15s %-15s %-15s%n", code, city, date, participants, equipment, invoice, cancel, room, customer, center);
							    }
							    //-----------------------------------------------------------------------------------------------------------------------------------------
							} catch(SQLException s) {
							    System.out.println("SQL code does not execute.");
							}
							
							valid = false;
							do {
								valid=false;
								System.out.print("\nEnter reservation code to update: ");
								res_code = scanner.nextLine();
								try {
									Statement st1 = conn.createStatement();
									ResultSet res1 = st1.executeQuery("SELECT * FROM reservesion WHERE res_code='"+res_code+"'");
									if (!res1.next()) {
										System.out.println("Error: Reservation code ["+res_code+"] not found in database!");
									}
									else {
										valid=true;
									}
								}catch(SQLException s){
									System.out.println("SQL code does not execute.");
								}
							}while(valid==false);

							do { //check the validity of input value
							    try {
							        System.out.print("\n\n\n\n\n\n\n\n\n\nSelect column to update: \n[1]City\n[2]Date\n[3]Participants\n[4]Equipment Pref\n[5]Invoice Option\n[6]Cancel Status\n[7]Room Code\n[8]Customer\n[9]Center Code");
							        System.out.print("\nEnter selection: ");
							        select = scanner.nextInt();
							        scanner.nextLine();
							    } catch(Exception e) {
							        e.printStackTrace();
							        scanner.next();
							        select = 0;
							        flag = true;
							    }
							    if ((flag==false)&&((select<1)||(select>9))) {
							        System.out.print("Invalid input [Enter numbers between 1 and 9]\n");
							    }
							    else if(flag) {
							        System.out.print("Invalid input\n");
							    }
							    flag=false;
							} while((select<1)||(select>9));

							switch(select) { //use switch to put correct columnt name into col_name for use later in query
							    case 1:
							        col_name = "res_resCity";
							        break;
							    case 2:
							        col_name = "res_hmerominia";
							        break;
							    case 3:
							        col_name = "res_summetexontes";
							        break;
							    case 4:
							        col_name = "res_protimiseisEjoplismou";
							        break;
							    case 5:
							        col_name = "res_timologio";
							        break;
							    case 6:
							        col_name = "res_akurosi";
							        break;
							    case 7:
							        col_name = "room_code";
							        break;
							    case 8:
							        col_name = "cus_onoma";
							        break;
							    case 9:
							        col_name = "center_code";
							        break;
							}

							flag=false; //use for error message
							do { //check the validity of input value
							    flag=false;
							    try {
							        System.out.print("\nEnter new value: ");
							        newField = scanner.nextLine();
							        
							        // Additional validation for numeric fields
							        if (col_name.equals("res_summetexontes") || col_name.equals("res_timologio") || col_name.equals("res_akurosi")) {
							            try {
							                Integer.parseInt(newField);
							            } catch(NumberFormatException e) {
							                System.out.print("Invalid input [Must be a number]\n");
							                flag = true;
							            }
							        }
							    } catch(Exception e) {
							        e.printStackTrace();
							        scanner.next();
							        newField = "";
							        flag = true;
							    }
							    if(flag) {
							        System.out.print("Invalid input\n");
							    }
							} while(flag);

							//----------------------------------------------execute update query for reservation----------------------------------------------
							try {
							    Statement st = conn.createStatement();
							    // Handle numeric fields differently
							    if (col_name.equals("res_summetexontes") || col_name.equals("res_timologio") || col_name.equals("res_akurosi")) {
							        st.executeUpdate("UPDATE reservesion SET "+col_name+"="+newField+" WHERE res_code = '"+res_code+"'");
							    } else {
							        st.executeUpdate("UPDATE reservesion SET "+col_name+"='"+newField+"' WHERE res_code = '"+res_code+"'");
							    }
							    System.out.println("1 row affected");
							} catch(SQLException s) {
							    System.out.println("SQL Error: " + s.getMessage());
							    System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							break;
							
						case 5: // if [5]Update Payment (Reservations menu) option is selected
							
							pay_code = 0;
							try {
							    Statement st = conn.createStatement();
							    //--------------------------------------------------------Payment Catalog--------------------------------------------------------
							    ResultSet res = st.executeQuery("SELECT * FROM payment");
							    System.out.print("\n\n");
							    System.out.printf("%-10s %-10s %-15s %-15s %-20s %-15s %-20s%n", "Pay Code", "Amount", "Method", "Status", "Date", "Res Code", "Customer");
							    while (res.next()) {
							        int code = res.getInt("pay_code");
							        double amount = res.getDouble("pay_poso");
							        String method = res.getString("pay_methodos");
							        String status = res.getString("pay_katastash");
							        String date = res.getString("pay_hmeromhnia");
							        String resCode = res.getString("res_code");
							        String customer = res.getString("cus_onoma");
							        
							        System.out.printf("%-10d %-10.2f %-15s %-15s %-20s %-15s %-20s%n", code, amount, method, status, date, resCode, customer);
							    }
							    //-----------------------------------------------------------------------------------------------------------------------------------------
							} catch(SQLException s) {
							    System.out.println("SQL code does not execute.");
							}
							
							//check if pay code exists in database
							do {
								flag=false;
								System.out.print("Enter payment code to update: ");
								pay_code = scanner.nextInt();
								try {
									Statement st1 = conn.createStatement();
									ResultSet res1 = st1.executeQuery("SELECT * FROM payment WHERE pay_code="+pay_code);
									if (!res1.next()) {
										System.out.println("Error: Payment Code ["+pay_code+"] not found in database!");
									}
									else {
										flag=true;
									}
								}catch(SQLException s){
									System.out.println("SQL code does not execute.");
								}
							}while(flag==false);
							
							flag = false;
							do { //check the validity of input value
								flag=false;
							    try {
							        System.out.print("\n\n\n\n\n\n\n\n\n\nSelect column to update: \n[1]Amount\n[2]Method\n[3]Status\n[4]Date\n[5]Reservation Code\n[6]Customer");
							        System.out.print("\nEnter selection: ");
							        select = scanner.nextInt();
							        scanner.nextLine();
							    } catch(Exception e) {
							        e.printStackTrace();
							        select = 0;
							        flag = true;
							    }
							    if ((flag==false)&&((select<1)||(select>6))) {
							        System.out.print("Invalid input [Enter numbers between 1 and 6]\n");
							    }
							    else if(flag) {
							        System.out.print("Invalid input\n");
							    }
							    flag=false;
							} while((select<1)||(select>6));

							switch(select) {
							    case 1:
							        col_name = "pay_poso";
							        break;
							    case 2:
							        col_name = "pay_methodos";
							        break;
							    case 3:
							        col_name = "pay_katastash";
							        break;
							    case 4:
							        col_name = "pay_hmeromhnia";
							        break;
							    case 5:
							        col_name = "res_code";
							        break;
							    case 6:
							        col_name = "cus_onoma";
							        break;
							}

							flag=false; //use for error message
							do { //check the validity of input value
							    flag=false;
							    try {
							        if (col_name.equals("pay_methodos")){
							        	boolean flag_in=false; //use for error message
										do { //check the validity of input value
											flag_in=false;
											try {
												System.out.print("\nSelect payment method:\n[0]Cash\n[1]Card\nEnter your selection: ");
												temp = scanner.nextInt();
												scanner.nextLine();
											}catch(Exception e) {
												e.printStackTrace();
												scanner.next();
												temp = 0;
												flag_in = true;
											}
											if ((temp!=0)&&(temp!=1)) {
												System.out.print("Invalid input [Select Card(1) or Cash(0)]\n");
												flag_in=true;
											}
											else if(flag){
												System.out.print("Invalid input\n");
											}
											if (temp==1) {
												newField = "Card";
											}
											else {
												newField = "Cash";
											}
										}while(flag_in);
							        }        
							        else if (col_name.equals("pay_katastash")){
							        	boolean flag_in=false; //use for error message
										do { //check the validity of input value
											flag_in=false;
											try {
												System.out.print("\nSelect payment status:\n[0]Pending\n[1]Completed\nEnter your selection: ");
												temp = scanner.nextInt();
												scanner.nextLine();
											}catch(Exception e) {
												e.printStackTrace();
												scanner.next();
												temp = 0;
												flag_in = true;
											}
											if ((temp!=0)&&(temp!=1)) {
												System.out.print("Invalid input [Select Pending(0) or Completed(1)]\n");
												flag_in=true;
											}
											else if(flag){
												System.out.print("Invalid input\n");
											}
											if (temp==0) {
												newField = "pending";
											}
											else {
												newField = "completed";
											}
										}while(flag_in);
							        }
							        else {        
								        System.out.print("\nEnter new value: ");
								        newField = scanner.nextLine();
								        
								        // Additional validation for specific fields
								        if (col_name.equals("pay_poso")) {
								        	try {
								        		Double.parseDouble(newField);
								        	} catch(NumberFormatException e) {
								        		System.out.print("Invalid input [Must be a number]\n");
								        		flag = true;
								        	}
								        } 
							        }
							    } catch(Exception e) {
							        e.printStackTrace();
							        scanner.next();
							        newField = "";
							        flag = true;
							    }
							    if(flag) {
							        System.out.print("Invalid input\n");
							    }
							} while(flag);

							//----------------------------------------------execute update query for payment----------------------------------------------
							try {
							    Statement st = conn.createStatement();
							    // Handle numeric field differently
							    if (col_name.equals("pay_poso")) {
							        st.executeUpdate("UPDATE payment SET "+col_name+"="+newField+" WHERE pay_code = "+pay_code);
							    } else {
							        st.executeUpdate("UPDATE payment SET "+col_name+"='"+newField+"' WHERE pay_code = "+pay_code);
							    }
							    System.out.println("1 row affected");
							} catch(SQLException s) {
							    System.out.println("SQL Error: " + s.getMessage());
							    System.out.println("SQL statement is not executed!");
							}
							//----------------------------------------------------------------------------------------------------------------------------
							
							
							break;
							
						case 6: //if [6]View/Delete canceled reservations (Reservations menu) option is selected
							
							String dateNow = LocalDate.now().toString(); //get curent date in our format in string type so that we compare it to the reservation dates on our query
							try {
							    Statement st = conn.createStatement();
							    //--------------------------------------------------------Reservation Catalog--------------------------------------------------------
							    ResultSet res = st.executeQuery("SELECT * FROM reservesion WHERE res_akurosi=1 and res_hmerominia<'"+dateNow+"'");
							    System.out.print("\n\n");
							    System.out.printf("%-15s %-15s %-15s %-10s %-20s %-10s %-10s %-15s %-15s %-15s%n", "Res Code", "City", "Date", "Participants", "Equipment Pref", "Invoice", "Canceled", "Room Code", "Customer", "Center Code");
							    while (res.next()) {
							        String code = res.getString("res_code");
							        String city = res.getString("res_resCity");
							        String date = res.getString("res_hmerominia");
							        int participants = res.getInt("res_summetexontes");
							        String equipment = res.getString("res_protimiseisEjoplismou");
							        int invoice = res.getInt("res_timologio");
							        String cancel = res.getInt("res_akurosi") == 1 ? "Yes" : "No";
							        String room = res.getString("room_code");
							        String customer = res.getString("cus_onoma");
							        String center = res.getString("center_code");
							        
							        System.out.printf("%-15s %-15s %-15s %-10d %-20s %-10d %-10s %-15s %-15s %-15s%n", code, city, date, participants, equipment, invoice, cancel, room, customer, center);
							    }
						        
							} catch(SQLException s) {
							    System.out.println("SQL code does not execute.");
							}
							
							flag=false; //use for error message
							do { //check the validity of input value
								flag=false;
								try {
									System.out.print("\nWould you like to delete those reservations?\n[0]No\n[1]Yes\nEnter your selection: ");
									select = scanner.nextInt();
									scanner.nextLine();
								}catch(Exception e) {
									e.printStackTrace();
									scanner.next();
									select = 0;
									flag = true;
								}
								if ((select!=0)&&(select!=1)) {
									System.out.print("Invalid input [Select Yes(1) or No(0)]\n");
									flag=true;
								}
								else if(flag){
									System.out.print("Invalid input\n");
								}
							}while(flag);
							
							if (select==1) {
								List<String> codeList = new ArrayList<>(); //store the codes we need in list
								try {
									Statement st = conn.createStatement();
									ResultSet res = st.executeQuery("SELECT * FROM reservesion WHERE res_akurosi=1 and res_hmerominia<'"+dateNow+"'");
									while(res.next()) {
										codeList.add(res.getString("res_code"));
									}
								} catch(SQLException s) {
									System.out.println("SQL Error: " + s.getMessage());
									System.out.println("SQL statement is not executed!");
								}
								
								for(String code : codeList) { //for each code
									
									//Step 1: Store the pay_code of the payment row of the reservation we want to delete
									int payCodeDelete=-1;
									try {
										Statement st = conn.createStatement();
										ResultSet res = st.executeQuery("SELECT * FROM payment WHERE res_code='"+code+"'");
										res.next();
										payCodeDelete = res.getInt("pay_code");
									}catch(SQLException s) {
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL statement is not executed!");
									}
									
									//Step 2: On our payment row set res_code and cus_onoma to NULL value so that its unlinked from the reservation row. Now we can delete the reservation
									try {
										Statement st = conn.createStatement();
										st.executeUpdate("UPDATE payment SET res_code = NULL, cus_onoma = NULL WHERE res_code = '"+code+"'");
										System.out.println("1 row affected (res_code, cus_onoma set to NULL successfully)");
									}catch(SQLException s) {
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL statement is not executed!");
									}
									
									//Step 3: Proceed to deleting the reservation row
									try {
										Statement st = conn.createStatement();
										st.executeUpdate("Delete FROM reservesion WHERE res_code='"+code+"'");
										System.out.println("1 row affected (reservation deleted successfully)");
									}catch(SQLException s) {
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL statement is not executed!");
									}
									
									//Step 4: Delete the payment row by identifying it using the pay_code we stored earlier
									try {
										Statement st = conn.createStatement();
										st.executeUpdate("Delete FROM payment WHERE pay_code="+payCodeDelete);
										System.out.println("1 row affected (payment deleted successfully)");
									}catch(SQLException s) {
										System.out.println("SQL Error: " + s.getMessage());
										System.out.println("SQL statement is not executed!");
									}
									
								}
								
							}
							
							break;
							
						case 7: //if [7]Back(Reservations menu) option is selected 
							flag_back=true;
							break;
						}
					}while(flag_back==false);
					break;
				case 5: //if [5]Exit (home menu) option is selected
					System.exit(0); //terminate program 
					break;
			}
	}
}
}
//e23152
//e23021
//ds unipi 2025
