package Control;

import Model.Emprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmprestimoDao {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private String sql;

    public EmprestimoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void empresta(Emprestimo emprestimo) {
        sql = "insert into empresta "
                + "(codigo, numero, isbn, data_emprestimo)"
                + " values (?, ?, ?, ?)";
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, emprestimo.getCodigo());
            pstmt.setInt(2, emprestimo.getNumero());
            pstmt.setInt(3, emprestimo.getIsbn());
            pstmt.setString(4, emprestimo.getData_emprestimo());

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void devolve(Emprestimo emprestimo) {
        sql = "delete from empresta where isbn = ? and numero = ? ";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, emprestimo.getIsbn());
            pstmt.setInt(2, emprestimo.getNumero());

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Emprestimo getEmprestimo(int isbn, int numero) {
        sql = "select * from empresta where isbn = ? and numero = ? ";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, isbn);
            pstmt.setInt(2, numero);
            rs = pstmt.executeQuery();
            Emprestimo instancia = new Emprestimo();
            while (rs.next()) {
                instancia.setIsbn(isbn);
                instancia.setNumero(numero);
                instancia.setCodigo(rs.getInt("codigo"));
                instancia.setData_emprestimo(rs.getString("data_emprestimo"));
            }
            rs.close();
            pstmt.close();
            return instancia;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
