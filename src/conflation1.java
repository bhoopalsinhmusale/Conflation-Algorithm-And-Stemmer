//bhoopal

                                            //Conflation.java

import java.io.*;
import java.sql.*;
import java.util.*;
public class conflation1
{
 
    public static void main(String[] args) throws Exception {
        
    
 //public conflation1() throws Exception
// public static void main(String args[])throws Exception 
 
    File outfile=new File("D:\\java programs\\conflation\\output.txt");
    File stopwordfile=new File("D:\\java programs\\conflation\\stopwords.txt");

        outfile.createNewFile();
        stopwordfile.createNewFile();
     
         //to clean out.txt
        FileWriter fw1 = new FileWriter(outfile,false);
        BufferedWriter bw1 = new BufferedWriter(fw1);
        PrintWriter pw1 = new PrintWriter(bw1);
        pw1.print("");
        pw1.close();
        String data=new String();
	String[] x=null;
                      try
		     {
                                // Open the file that is the first
                                // command line parameter
                                FileInputStream fstream = new
				FileInputStream("D:\\java programs\\conflation\\input.txt");

                                // Convert our input stream to a
                                // DataInputStream
				DataInputStream in = new DataInputStream(fstream);

                                // Continue to read lines while
                                // there are still some left to read
                                while (in.available() !=0)
				{
                                        // Print file line to screen
					data=in.readLine();
					System.out.println ("Input File Data :\n"+data);
				}
                                System.out.println("\n");
				in.close();
                      }
                        catch (Exception e)
			{
				System.err.println("File input error");
			}

      //**********************MS Access Connectivity***************

       Connection con;
	Statement stmt;
	ResultSet rs;

	try{
	//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	con = DriverManager.getConnection( "jdbc:ucanaccess://D:\\java programs\\conflation\\db11.accdb", "","");
	stmt = con.createStatement();
	rs = stmt.executeQuery("SELECT * FROM stopwordtable");
	System.out.println("database stopwords:");
        
        int i=0;
        x=new String[1024];              // table of stop words

	while (rs.next()) {
	x[i] = rs.getString("word");

	System.out.println(" "+x[i]);
	i++;
	}
        System.out.println("\n");
 	}

	catch(SQLException e){
	System.out.println("Hello World!"+e);
	}


        //****************Stop word removal********************************



	char[] fdata=data.toCharArray();
	char[] temp=new char[1024];
       String newdata=new String();

       String tem;
       

        int k=0,n,i;

       
               for(i=0;i<data.length();i++)
		{
                  if(fdata[i]==' '|| fdata[i]=='.' || fdata[i]==',' || fdata[i]=='!' || fdata[i]==':' || fdata[i]==';' || fdata[i]=='"' || fdata[i]=='\'' || fdata[i]=='?')
 		 {
                  	tem=new String(temp,0,k);
                      //System.out.println("current word: " +tem);
                        k=0; int flag=0;
                        //code for comapring word with stoptable words....
 		        for(n=0;n<320;n++)
                        {
                            
                          if(x[n].equalsIgnoreCase(tem))

                          {
                          
                           // System.out.println("n: " +(n+1));
                            //System.out.println("Stop word: " +x[n]);
                            flag=1;
                            break;
                            
                          }
                          else
                          {
                              //System.out.println("n: " +(n+1));
                              //System.out.println("else tem: " +tem);
                              continue;
                             
                          }
                         
                       }
                        if(flag==1)
                         {
                             FileWriter fw = new FileWriter(stopwordfile,false);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.println("");
                            pw.println(x[n]);
                            pw.close();
                            
                         }
                         else
                         {
                              FileWriter fw = new FileWriter(outfile,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.print(" ");
                            pw.print(tem);
                            pw.close();
                          
                         }
                         

                 }
		 else
		 {
                  temp[k]=fdata[i];
                  k++;
                  }
                 }
               
               
               
               //for last word in file
               {
                   
                  	tem=new String(temp,0,k);
                      //System.out.println("current word: " +tem);
                        k=0; int flag=0;
                        //code for comapring word with stoptable words....
 		        for(n=0;n<5;n++)
                        {
                            
                          if(x[n].equalsIgnoreCase(tem))

                          {
                          
                           // System.out.println("n: " +(n+1));
                            //System.out.println("Stop word: " +x[n]);
                            flag=1;
                            break;
                            
                          }
                          else
                          {
                              //System.out.println("n: " +(n+1));
                              //System.out.println("else tem: " +tem);
                              continue;
                             
                          }
                         
                       }
                        if(flag==1)
                         {
                             FileWriter fw = new FileWriter(stopwordfile,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.println("");
                            pw.println(x[n]);
                            pw.close();
                            
                         }
                         else
                         {
                              FileWriter fw = new FileWriter(outfile,true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);
                            pw.print(" ");
                            pw.print(tem);
                            pw.close();
                          
                         }
                         

                }

              
Stemmer s1=new Stemmer(1);
         
  }
}
