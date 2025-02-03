
import java.util.List;

public interface ILivro {

    public String getId();

    public String getTitulo();

    public String getEdicao();

    public String getEditora();

    public List<String> getAutores();

    public String getAnoPublicacao();

    public int getQuantidadeExemplares();
}
