import exercises.ex1.Duck$;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by : Dmitry Karlinsky
 * Date: 7/24/13 6:27 PM
 */
public class TestInterop
{

    @Test
    public void testPersonJavaBeanProps() throws Exception
    {
        PersonWithBeanProps dmitry = new PersonWithBeanProps(36, "dmitry");

        assertEquals("dmitry", dmitry.getName());
        assertEquals(36, dmitry.getAge());
        assertTrue(dmitry.isCool());

        dmitry.setAge(24);
        dmitry.setName("Dmitry");

        assertEquals("Dmitry", dmitry.getName());
        assertEquals(24, dmitry.getAge());
        assertTrue(dmitry.isCool());

        //Duck$.MODULE$.
    }

    @Test
    public void testSimpleScalaPerson() throws Exception
    {
        Person dmitry = new Person(24, "dmitry");
        assertEquals("dmitry", dmitry.name());
        assertEquals(24, dmitry.age());

    }
}
