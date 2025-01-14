/*
Um livro específico pode ter mais de um exemplar disponível na biblioteca. Assim, é possível
encontrar dois ou mais exemplares de um mesmo livro.
Cada livro deve possuir um código de identificação e um título. Além do código e título, os livros
devem incluir informações adicionais, como editora, autores, edição e ano de publicação. 
*/

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
