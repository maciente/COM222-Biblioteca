package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarPublicacao extends HttpServlet {

    private String isbn, titulo, autor, editora, ano;
    private PreparedStatement pstmt;

    public void init() throws ServletException {
        inicializaJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Obtem os dados do formulário
        isbn = request.getParameter("isbn");
        titulo = request.getParameter("titulo");
        autor = request.getParameter("autor");
        editora = request.getParameter("editora");
        ano = request.getParameter("ano");
        try {
            armazenaPublicacao();
            out.println("Publicação " + titulo + " está agora registrada na base de dados");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            pstmt = c.prepareStatement("insert into publicacao "
                    + "(isbn, titulo, autor, editora, ano)"
                    + " values (?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void armazenaPublicacao() throws SQLException {
        pstmt.setInt(1, Integer.parseInt(isbn));
        pstmt.setString(2, titulo);
        pstmt.setString(3, autor);
        pstmt.setString(4, editora);
        pstmt.setInt(5, Integer.parseInt(ano));
        pstmt.executeUpdate();
    }
}
