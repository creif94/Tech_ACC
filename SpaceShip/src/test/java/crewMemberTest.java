import com.example.SpaceShip.CrewMember.CrewMember;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class crewMemberTest {

    @Test
    public void creteNewCrewMember(){
        CrewMember firstCrewMember = new CrewMember();
        firstCrewMember.setCrewMemberID(1L);
        firstCrewMember.setCrewName("James");
        assertTrue(firstCrewMember instanceof CrewMember);
        assertEquals(1L, firstCrewMember.getCrewMemberID());
        assertEquals("James", firstCrewMember.getCrewName());
    }


}
