import java.net.URI;

public interface Browseable {

    public void visit(URI uri);

    public URI getCurrentPage();
}

class Crawler implements Browseable{
    private URI currentPage;

    @Override
    public void visit(URI uri) {
        currentPage = uri;


    }

    @Override
    public URI getCurrentPage() {
        return currentPage;
    }

}
