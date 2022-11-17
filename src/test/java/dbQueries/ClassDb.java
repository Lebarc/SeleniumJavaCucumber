/*
package dbQueries;

//import pessoas.ClassPessoa;

import java.sql.*;

public class ClassDb {



//    public static String[] PesquisaUsuariosWeb() {
//        Connection con = getConnection();
//        String[] list = new String[3];
//
//        try {
//            PreparedStatement stm = con.prepareStatement("select * from usuarios_web where cpf =?");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                list[0] = result.getString("id");
//                list[1] = result.getString("cpf");
//                list[2] = result.getString("nome");
//            }
//            con.close();
//            return list;
//        } catch (SQLException e) {
//            System.out.println("PesquisaUsuariosWeb -> " + e);
//            return null;
//        }
//    }
//
//    public static String PesquisaCodFiador() {
//        Connection con = getConnection();
//        String codFiador = "";
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("select sw.cod_aceite_fiador1 from solicitacoes_web sw, pessoas_web pw\n" +
//                            "where pw.id = sw.psa_bolsista_id\n" +
//                            "and pw.cpf =?");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                codFiador = result.getString("cod_aceite_fiador1");
//            }
//            con.close();
//            return codFiador;
//        } catch (SQLException e) {
//            System.out.println("PesquisaCodFiador -> " + e);
//            return null;
//        }
//    }
//
//    public static void UpdateIdFiadorSolicitacao() {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("update solicitacoes_web " +
//                            "set psa_fiador_id = null, " +
//                            "cod_aceite_fiador1 = null, " +
//                            "cod_preenchimento_fiador = null " +
//                            "where psa_bolsista_id = (select id from pessoas_web where cpf =?)");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("UpdateIdFiadorSolicitacao -> " + e);
//        }
//    }
//
//    public static String PesquisaCodPreenchimentoFiador() {
//        Connection con = getConnection();
//        String codFiador = "";
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("select sw.cod_preenchimento_fiador from solicitacoes_web sw, pessoas_web pw\n" +
//                            "where pw.id = sw.psa_bolsista_id\n" +
//                            "and pw.cpf =?");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                codFiador = result.getString("cod_preenchimento_fiador");
//            }
//            con.close();
//            return codFiador;
//        } catch (SQLException e) {
//            System.out.println("PesquisaCodFiador -> " + e);
//            return null;
//        }
//    }
//
//    public static String[] PesquisaRegistroSolicitacaoWeb() {
//        Connection con = getConnection();
//        String[] list = new String[3];
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("select sw.status, sw.status_cadastro, sw.etapa_solicitacao from solicitacoes_web sw, pessoas_web pw\n" +
//                            "where pw.id = sw.psa_bolsista_id\n" +
//                            "and pw.cpf =? and rownum = 1");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                list[0] = result.getString("status");
//                list[1] = result.getString("status_cadastro");
//                list[2] = result.getString("etapa_solicitacao");
//            }
//            con.close();
//            return list;
//        } catch (SQLException e) {
//            System.out.println("PesquisaCodFiador -> " + e);
//            return null;
//        }
//    }
//
//    public static void DeletarOcorrenciasSolicitacoesWeb(String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("delete from OCORRENCIAS_SOLICITACAO_WEB where sol_id in " +
//                            "(select id from solicitacoes_web where psa_bolsista_id in " +
//                            "(select id from pessoas_web where cpf =?))");
//
//            stm.setString(1, cpf);
//            stm.executeUpdate();
//
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("DeletarOcorrenciasSolicitacoesWeb -> " + e);
//        }
//    }
//
//    public static void DeletarSolicitacoesWeb(String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("delete from solicitacoes_web " +
//                            "where psa_bolsista_id in (select id from pessoas_web where cpf =?)");
//
//            stm.setString(1, cpf);
//            stm.executeUpdate();
//
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("DeletarSolicitacoesWeb -> " + e);
//        }
//    }
//
//    public static void DeletarSolicitacoesWebAudit(String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("delete from solicitacoes_web_audit " +
//                            "where psa_bolsista_id in (select id from pessoas_web where cpf =?)");
//
//            stm.setString(1, cpf);
//            stm.executeUpdate();
//
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("DeletarSolicitacoesWebAudit -> " + e);
//        }
//    }
//
//    public static void DeletarPessoasWeb(String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("delete from pessoas_web where cpf =?");
//
//            stm.setString(1, cpf);
//            stm.executeUpdate();
//
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("DeletarPessoasWeb -> " + e);
//        }
//    }
//
//    public static void DeletarPessoasWebAudit(String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("delete from pessoas_web_audit where cpf =?");
//
//            stm.setString(1, cpf);
//            stm.executeUpdate();
//
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("DeletarPessoasWebAudit -> " + e);
//        }
//    }
//
//    public static String PesquisarAutorizacaoFiador1() {
//        Connection con = getConnection();
//        String autorizacao = "";
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement
//                            ("select autorizacao_fiador1 \n" +
//                                    "from solicitacoes_web \n" +
//                                    "where psa_bolsista_id in \n" +
//                                    "(select id from pessoas_web \n" +
//                                    "where cpf =?)");
//            stm.setString(1, "66296255101");
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                autorizacao = result.getString("autorizacao_fiador1");
//            }
//            con.close();
//            return autorizacao;
//        } catch (SQLException e) {
//            System.out.println("PesquisarAutorizacaoFiador1 -> " + e);
//            return null;
//        }
//    }
//
//    public static String BuscarCodigoTelefone() {
//        Connection con = getConnection();
//        String cod = "";
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement
//                            ("select cod_validacao \n" +
//                                    "from validacao_telefone \n" +
//                                    "where telefone =?");
//            stm.setString(1, "+55" + ClassPessoa.telefoneEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                cod = result.getString("cod_validacao");
//            }
//            con.close();
//            return cod;
//        } catch (SQLException e) {
//            System.out.println("PesquisarAutorizacaoFiador1 -> " + e);
//            return null;
//        }
//    }
//
//    public static void UpdateSolicitacaoWebStatusCadastroPdc() {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("update solicitacoes_web \n" +
//                            "set status_cadastro = 'PDC' \n" +
//                            "where psa_bolsista_id = \n" +
//                            "(select id from pessoas_web \n" +
//                            "where cpf =?)");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("UpdateSolicitacaoWebStatusCadastroPdc -> " + e);
//        }
//    }
//
//    public static void UpdateConfirmarEmail(String status, String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("update pessoas_web set email_validado =? where cpf =?");
//            stm.setString(1, status);
//            stm.setString(2, cpf);
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("UpdateSolicitacaoWebStatusCadastroPdc -> " + e);
//        }
//    }
//
//    public static void UpdateConfirmarEmailConjuge(String status, String cpf) {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("update pessoas_web set email_conjuge_validado =? where cpf =?");
//            stm.setString(1, status);
//            stm.setString(2, cpf);
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("UpdateSolicitacaoWebStatusCadastroPdc -> " + e);
//        }
//    }
//
//    public static void UpdateClicksignId() {
//        Connection con = getConnection();
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement("update contratos c\n" +
//                            "    set c.clicksign_id = null\n" +
//                            "    where prc_id = (select prc.id\n" +
//                            "    from processos prc\n" +
//                            "    inner join pessoas p\n" +
//                            "    on p.id = prc.psa_id\n" +
//                            "    where p.cpf =?)");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            stm.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("UpdateSolicitacaoWebStatusCadastroPdc -> " + e);
//        }
//    }
//
//    public static String VerificarClicksignId() {
//        Connection con = getConnection();
//        String cod = "";
//
//        try {
//            PreparedStatement stm =
//                    con.prepareStatement
//                            ("select ctr.clicksign_id\n" +
//                                    "from pessoas p,\n" +
//                                    "processos prc,\n" +
//                                    "contratos ctr\n" +
//                                    "where\n" +
//                                    "p.id = prc.psa_id\n" +
//                                    "and prc.id = ctr.prc_id\n" +
//                                    "and p.cpf =?");
//            stm.setString(1, ClassPessoa.cpfEstudante);
//            ResultSet result = stm.executeQuery();
//
//            while (result.next()) {
//                cod = result.getString("clicksign_id");
//            }
//            con.close();
//            return cod;
//        } catch (SQLException e) {
//            System.out.println("PesquisarAutorizacaoFiador1 -> " + e);
//            return null;
//        }
 //   }
}*/
