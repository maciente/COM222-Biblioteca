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

public class CadastrarExemplar extends HttpServlet {

    private String isbn, numero, preco, situacao;
    private PreparedStatement pstmt;

    public void init() throws ServletException {
        inicializaJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Obtem os dados do formulário
        isbn = request.getParameter("isbn");
        numero = request.getParameter("numero");
        preco = request.getParameter("preco");
        situacao = request.getParameter("situacao");
        try {
            armazenaExemplar();
            out.println("Exemplar " + numero + " está agora registrado na base de dados");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            pstmt = c.prepareStatement("insert into exemplar "
                    + "(isbn, numero, preco, situacao)"
                    + " values (?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void armazenaExemplar() throws SQLException {
        pstmt.setInt(1, Integer.parseInt(isbn));
        pstmt.setInt(2, Integer.parseInt(numero));
        pstmt.setDouble(3, Double.parseDouble(preco));
        pstmt.setString(4, situacao);
        pstmt.executeUpdate();
    }
}
