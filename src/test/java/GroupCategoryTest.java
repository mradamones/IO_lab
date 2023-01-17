import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory({GroupTest.class})
@Suite.SuiteClasses({
        Zadanie2.class,
        Zadanie3.class,
        Zadanie4.class
})
public class GroupCategoryTest {

}
