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

public class CadastrarAssociado extends HttpServlet {

    private String codigo, nome, endereco, email, senha, tipo;
    private PreparedStatement pstmt;

    public void init() throws ServletException {
        inicializaJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Obtem os dados do formulário
        codigo = request.getParameter("codigo");
        nome = request.getParameter("nome");
        endereco = request.getParameter("endereco");
        email = request.getParameter("email");
        senha = request.getParameter("senha");
        tipo = request.getParameter("tipo");
        try {
            armazenaAssociado();
            out.println("Usuário " + nome + " está agora registrado na base de dados");
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            pstmt = c.prepareStatement("insert into associado "
                    + "(codigo, nome, endereco, email, senha, tipo)"
                    + " values (?, ?, ?, ?, ?, ?)");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void armazenaAssociado() throws SQLException {
        pstmt.setInt(1, Integer.parseInt(codigo));
        pstmt.setString(2, nome);
        pstmt.setString(3, endereco);
        pstmt.setString(4, email);
        pstmt.setString(5, senha);
        pstmt.setString(6, tipo);
        pstmt.executeUpdate();
    }
}
