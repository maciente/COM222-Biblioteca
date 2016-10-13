package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAuthentication extends HttpServlet {

    private PreparedStatement pstmt;
    private String codigo, senha, nome;

    public void init() throws ServletException {
        inicializaJdbc();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            codigo = request.getParameter("codigo");
            senha = request.getParameter("senha");
            pstmt.setString(1, codigo);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nome = rs.getString("nome");
                do {
                    out.println("Bem-vindo " + nome);
                } while (rs.next());
            } else {
                out.println("Não existe usuário com o código <b>" + codigo + "</b> ou a senha está incorreta ");
                out.println("<a href='login.jsp'><br>Tente Novamente</a>");
            }
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private void inicializaJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", "");
            pstmt = c.prepareStatement("select codigo, senha, nome from associado where codigo = ? and senha = ? ");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
