package Control;

import Model.Historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoricoDao {
    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    String sql;

    public HistoricoDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insereHistorico(Historico historico) {
        sql = "insert into historico "
                + "(codigo, isbn, numero, data_emprestimo, data_devolucao)"
                + " values (?, ?, ?, ?, ?)";
        try {
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, historico.getCodigo());
            pstmt.setInt(2, historico.getIsbn());
            pstmt.setInt(3, historico.getNumero());
            pstmt.setString(4, historico.getData_emprestimo());
            pstmt.setString(5, historico.getData_devolucao());

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
