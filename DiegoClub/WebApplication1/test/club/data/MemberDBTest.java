package club.data;


import java.util.ArrayList;
import club.business.Member;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.h2.jdbcx.JdbcDataSource;
import javax.naming.Context;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.InitialContext;


public class MemberDBTest {

    private Member testMember = null;
    private static InitialContext ic;
    
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
    
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
        ic = new InitialContext();
        
        //Create and bind a DataSource to the JNDI context
        ic.createSubcontext("java:");
        ic.createSubcontext("java:/comp");
        ic.createSubcontext("java:/comp/env");
        ic.createSubcontext("java:/comp/env/jdbc");
        
        //Initialize DataSource with H2 database for testing
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        dataSource.setUser("myMember");
        dataSource.setPassword("mypass");
        
        ic.bind("java:/comp/env/jdbc/memberdb", dataSource);
        
        //Get the conection
        Connection conn = null;
        Statement stmt = null;
        
        
        try{
        
            conn = dataSource.getConnection();
            stmt = conn.createStatement();
            //Create the schema and tables
            stmt.execute("CREATE TABLE member (" +
            "  MemberID INT NOT NULL AUTO_INCREMENT, " +
            "  FullName VARCHAR(50), " +
            "  EmailAddress VARCHAR(50)," +
            "  PhoneNumber VARCHAR(20)," +
             " ProgramName VARCHAR(20)," +
             " YearLevel INT," +
            "  PRIMARY KEY (MemberID))");
        
        
        }catch(SQLException e)
        {
            e.printStackTrace();       
        }
        finally{
           
           if (stmt!=null) {
            try {
            stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();}
            
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                e.printStackTrace();}
            
        }
    }
        
        
        
    }
    
     @AfterClass
    public static void tearDownClass() throws NamingException {
        //Unbind the DataScource from the JNDI context
        ic.unbind("java:/comp/env/jdbc/memberdb");
        System.clearProperty(Context.INITIAL_CONTEXT_FACTORY);
        System.clearProperty(Context.URL_PKG_PREFIXES);
    }
        
    
    @Before
    public void setUp() {
        testMember = new Member("Diego Ramos","test@example.com","5558884444","ITID",1);
    }
    
    @After
    public void tearDown() {
        //Clean up the database after each test case
        if (MemberDB.emailExists(testMember.getEmailAddress())) {
            MemberDB.delete(testMember);
        }
    }
    
    /**
     * Test of insert method, of class UserDB.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");        
        int expResult = 1;
        int result = MemberDB.insert(testMember);
        assertEquals(expResult,result);     
    }
    
      /**
     * Test of update method, of class UserDB.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        
        //Insert the user
        MemberDB.insert(testMember);
        
        //Modify the user's name
        testMember.setFullName("Diego Ramos");
        testMember.setEmailAddress("test@example.com");
        
        int result = MemberDB.update(testMember);
        assertEquals(1, result);
        
        //Retrieve the user and verify the changes
        Member updatedMember = MemberDB.selectMember(testMember.getEmailAddress());
        assertEquals("Diego Ramos", updatedMember.getFullName());
        assertEquals("test@example.com", updatedMember.getEmailAddress());

    }
    
    
    /**
     * Test of delete method, of class MemberDB.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        MemberDB.insert(testMember);
        int result = MemberDB.delete(testMember);
        assertEquals(1, result);
    }
    
    /**
     * Test of emailExists method, of class MemberDB.
     */
    @Test
    public void testEmailExists() {
        System.out.println("emailExists");
        MemberDB.insert(testMember);
        
        boolean exists = MemberDB.emailExists(testMember.getEmailAddress());
        assertTrue(exists);
        
    }
    
     /**
     * Test of selectMemer method, of class MemberDB.
     */
    @Test
    public void testSelectMember() {
        System.out.println("selectMember");
       
        MemberDB.insert(testMember);
        Member selectedMember = MemberDB.selectMember(testMember.getEmailAddress());
        
        assertEquals(testMember.getEmailAddress(), selectedMember.getEmailAddress());
        assertEquals(testMember.getFullName(), selectedMember.getFullName());
        assertEquals(testMember.getPhoneNumber(), selectedMember.getPhoneNumber());
        assertEquals(testMember.getProgramName(), selectedMember.getProgramName());
        assertEquals(testMember.getYearLevel(), selectedMember.getYearLevel());
        
    }
    
    /**
     * Test of selectMembers method, of class MemberDB.
     */
    @Test
    public void testSelectMembers() {
        System.out.println("selectMembers");
        
        //Insert some test users
        MemberDB.insert(new Member("Diego Ramos", "diego@gmail.com", "1234567890","ITID",2));
        MemberDB.insert(new Member("Joaquin Ramos", "joakito@gmail.com", "1234567891","ITID",1));
       
           
        ArrayList<Member> result = MemberDB.selectMembers();
        assertNotNull(result);
        assertEquals(2, result.size());
    }
    
}