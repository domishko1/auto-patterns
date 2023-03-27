package strategyPattern.tests;

import org.junit.Assert;
import org.junit.Test;
import strategyPattern.objects.ElectronicsCompanySearchStrategy;
import strategyPattern.objects.ProfilePage;
import strategyPattern.objects.SearchStrategy;
import strategyPattern.objects.TrueBeautySearchStrategy;

public class SearchTest extends BaseTest {
    @Test
    public void TrueBeautySearchTest() {
        ProfilePage profilePage = new ProfilePage();
        SearchStrategy searchStrategy = new TrueBeautySearchStrategy();

        searchStrategy.search();
        Assert.assertEquals("Кан Мин А", profilePage.getActorName());

    }

    @Test
    public void ElectronicsCompanySearchTest() {
        ProfilePage profilePage = new ProfilePage();
        SearchStrategy searchStrategy = new ElectronicsCompanySearchStrategy();

        searchStrategy.search();
        Assert.assertEquals("Кан Мин А", profilePage.getActorName());
    }
}
