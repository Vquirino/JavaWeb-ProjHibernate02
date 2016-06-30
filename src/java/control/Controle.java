package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import model.Turma;
import persistence.TurmaDao;

public class Controle extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Turma t = new Turma();
            t.setNome(request.getParameter("nome"));
            t.setDescricao(request.getParameter("descricao"));
            
            int dia = new Integer(request.getParameter("dia"));
            int mes = new Integer(request.getParameter("mes"));
            int ano = new Integer(request.getParameter("ano"));
            
            Calendar cal = new GregorianCalendar(ano, mes - 1, dia);
            t.setDataInicio(cal.getTime());
            
            Professor p = new Professor();
            p.setIdProfessor(new Integer(request.getParameter("professor")));
            
            t.setProfessor(p); //associar o professor à turma
            
            try {
                new TurmaDao().salvar(t);
                request.setAttribute("mensagem", "Turma cadastrada com sucesso");
            }
            catch(Exception e) {
                request.setAttribute("mensagem", e.getMessage());
            }
            finally {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
