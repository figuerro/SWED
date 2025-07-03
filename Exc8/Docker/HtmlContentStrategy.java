// Strategie 2: HTML Content

public class HtmlContentStrategy implements ComparisonStrategy {
    @Override
    public boolean hasChanged(String oldContent, String newContent) {
        return !oldContent.equals(newContent);
    }
}