package Control;

import Model.Associado;
import Model.Emprestimo;
import Model.Exemplar;
import Model.Historico;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RealizarDevolucao extends HttpServlet {

    private String situacao;
    private int isbn, numero;
    private Associado associado;
    private AssociadoDao aDao;
    private Emprestimo instancia;
    private EmprestimoDao iDao;
    private Historico historico;
    private HistoricoDao hDao;
    private Exemplar exemplar;
    private ExemplarDao eDao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        associado = new Associado();
        instancia = new Emprestimo();
        historico = new Historico();
        exemplar = new Exemplar();

        // Obtem os dados do formulário
        historico.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        historico.setNumero(Integer.parseInt(request.getParameter("numero")));
        historico.setData_devolucao(request.getParameter("dataDevolucao"));
        try {
            isbn = historico.getIsbn();
            numero = historico.getNumero();

            iDao = new EmprestimoDao();
            instancia = iDao.getEmprestimo(isbn, numero);
            eDao = new ExemplarDao();
            exemplar = eDao.selectExemplar(isbn, numero);
            situacao = exemplar.getSituacao();

            historico.setCodigo(instancia.getCodigo());
            historico.setData_emprestimo(instancia.getData_emprestimo());
            //associado = aDao.getAssociado(historico.getCodigo());
            if (situacao.equals("emprestado")) {
                hDao = new HistoricoDao();
                hDao.insereHistorico(historico);
                iDao.devolve(instancia);
                eDao.setSituacao(exemplar, "disponivel");
//                if ("Grad".equals(associado.getTipo())) {
//                    int dias = 7;
//                    int atraso = calculaAtraso(historico.getData_emprestimo(),
//                            historico.getData_devolucao());
//                    if ((atraso - dias > 0)) {
//                        out.println("<p>Multa por atraso: " + (atraso - dias));
//                    } else {
//                        out.println("<p>Não há atraso");
//                    }
//                } else if ("Posgrad".equals(associado.getTipo())) {
//                    int dias = 10;
//                    int atraso = calculaAtraso(historico.getData_emprestimo(),
//                            historico.getData_devolucao());
//                    if ((atraso - dias > 0)) {
//                        out.println("<p>Multa por atraso: " + (atraso - dias));
//                    } else {
//                        out.println("<p>Não há atraso");
//                    }
//                } else if ("Prof".equals(associado.getTipo())) {
//                    int dias = 14;
//                    int atraso = calculaAtraso(historico.getData_emprestimo(),
//                            historico.getData_devolucao());
//                    if ((atraso - dias > 0)) {
//                        out.println("<p>Multa por atraso: " + (atraso - dias));
//                    } else {
//                        out.println("<p>Não há atraso");
//                    }
//                }
                out.println("<p>Devolução feita com sucesso");
            } else if (situacao.equals("disponivel")) {
                out.println("Exemplar ja foi devolvido");
            }
        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        }
    }

    public int calculaAtraso(String dataEmprestimo, String dataDevolucao) throws ParseException {
        Calendar dtEmprestimo = Calendar.getInstance();
        Calendar dtDevolucao = Calendar.getInstance();
        String[] emp = dataEmprestimo.split("/");
        int diaE = Integer.parseInt(emp[0]);
        int mesE = Integer.parseInt(emp[1]) - 1;
        int anoE = Integer.parseInt(emp[2]);
        dtEmprestimo.set(anoE, mesE, diaE);
        String[] dev = dataDevolucao.split("/");
        int diaD = Integer.parseInt(dev[0]);
        int mesD = Integer.parseInt(dev[1]) - 1;
        int anoD = Integer.parseInt(dev[2]);
        dtDevolucao.set(anoD, mesD, diaD);
        dtDevolucao.add(Calendar.DATE, -dtEmprestimo.get(Calendar.DAY_OF_MONTH));
        return dtDevolucao.get(Calendar.DAY_OF_MONTH);
    }
}
