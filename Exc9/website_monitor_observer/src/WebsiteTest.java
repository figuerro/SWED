import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Website Monitor Tests")
class WebsiteTest {

    private Website website;

    @Test
    @DisplayName("Valid HTTPS URL should work without throwing exception")
    void testValidHttpsUrl() {
        website = new Website("https://www.google.com", new ContentSizeStrategy());

        assertDoesNotThrow(() -> {
            website.checkForUpdates();
        }, "Valid HTTPS URL should not throw exception");
    }

    @Test
    @DisplayName("Valid HTTP URL should work without throwing exception")
    void testValidHttpUrl() {
        website = new Website("http://example.com", new ContentSizeStrategy());

        assertDoesNotThrow(() -> {
            website.checkForUpdates();
        }, "Valid HTTP URL should not throw exception");
    }

    @Test
    @DisplayName("Invalid protocol should return false")
    void testInvalidProtocol() {
        website = new Website("htpps://www.google.com", new ContentSizeStrategy());

        boolean result = website.checkForUpdates();

        assertFalse(result, "Invalid protocol should return false");
    }

    @Test
    @DisplayName("Invalid URL format should return false")
    void testInvalidFormat() {
        website = new Website("not a url", new ContentSizeStrategy());

        boolean result = website.checkForUpdates();

        assertFalse(result, "Invalid URL format should return false");
    }

    @Test
    @DisplayName("Empty string should return false")
    void testEmptyString() {
        website = new Website("", new ContentSizeStrategy());

        boolean result = website.checkForUpdates();

        assertFalse(result, "Empty string should return false");
    }

    @Test
    @DisplayName("Unreachable URL should return false")
    void testUnreachableUrl() {
        website = new Website("http://nonexistent.domain.abc", new ContentSizeStrategy());

        boolean result = website.checkForUpdates();

        assertFalse(result, "Unreachable URL should return false");
    }

    @Test
    @DisplayName("Test all three strategies with valid URL")
    void testAllStrategies() {
        String validUrl = "https://www.google.com";

        Website website1 = new Website(validUrl, new ContentSizeStrategy());
        Website website2 = new Website(validUrl, new HtmlContentStrategy());
        Website website3 = new Website(validUrl, new TextContentStrategy());

        assertAll("All strategies should work with valid URL",
                () -> assertDoesNotThrow(() -> website1.checkForUpdates()),
                () -> assertDoesNotThrow(() -> website2.checkForUpdates()),
                () -> assertDoesNotThrow(() -> website3.checkForUpdates())
        );
    }
}
