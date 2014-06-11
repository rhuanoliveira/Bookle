/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookleprojeto;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author admin
 */
public class TelaLivrosSugeridos extends javax.swing.JInternalFrame {

    TelaPesquisar telapesquisar = new TelaPesquisar();

    /**
     * Creates new form Teste
     */
    public TelaLivrosSugeridos() {
        initComponents();
        iniciaTables();

    }

    public void iniciaTables() {

        selectTable("SELECT * FROM tblivros INNER JOIN tbdisciplina ON tblivros.coddisciplina = tbdisciplina.coddisciplina AND tbdisciplina.nomedisciplina LIKE" + "'" + telapesquisar.getResNomedisciplina() + "'", "nomelivro", "contexemplares", "localbiblioteca", "statuslivro", jtableLivros);

        if (telapesquisar.getResNomedisciplina02() != null) {
            selectTable("SELECT * FROM tblivros INNER JOIN tbdisciplina ON tblivros.coddisciplina = tbdisciplina.coddisciplina AND tbdisciplina.nomedisciplina LIKE" + "'" + telapesquisar.getResNomedisciplina02() + "'", "nomelivro", "contexemplares", "localbiblioteca", "statuslivro", jtableLivros02);
        }

        if (telapesquisar.getResNomedisciplina03() != null) {
            selectTable("SELECT * FROM tblivros INNER JOIN tbdisciplina ON tblivros.coddisciplina = tbdisciplina.coddisciplina AND tbdisciplina.nomedisciplina LIKE" + "'" + telapesquisar.getResNomedisciplina03() + "'", "nomelivro", "contexemplares", "localbiblioteca", "statuslivro", jtableLivros03);
        }
    }

    public void selectTable(String selectQuery, String nomecoluna, String nomecoluna2, String nomecoluna3, String nomecoluna4, JTable jtable) {
        ArrayList dados = new ArrayList();

        dados.clear();
        String[] colunas = new String[]{"Nome Livro", "Exemplares", "Biblioteca", "Status"};
        try {

            ConexaoMysql conectmysql = new ConexaoMysql();
            conectmysql.abrirConexao();
            conectmysql.statement = conectmysql.conexao.createStatement();
            conectmysql.resultset = conectmysql.statement.executeQuery(selectQuery);

            while (conectmysql.resultset.next()) {

                dados.add(new Object[]{conectmysql.resultset.getString(nomecoluna), conectmysql.resultset.getString(nomecoluna2), conectmysql.resultset.getString(nomecoluna3), conectmysql.resultset.getString(nomecoluna4)});
            }

            conectmysql.statement.close();

        } catch (Exception erro) {
            System.out.println("Erro preencher Tabela: " + erro);

        }
        ModeloTabela modeltable = new ModeloTabela(dados, colunas);

        if (jtable == jtableLivros) {
            jtableLivros.setModel(modeltable);
            jtableLivros.getColumnModel().getColumn(0).setPreferredWidth(350);
            jtableLivros.getColumnModel().getColumn(0).setResizable(false);
            jtableLivros.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtableLivros.getColumnModel().getColumn(1).setResizable(false);
            jtableLivros.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtableLivros.getColumnModel().getColumn(2).setResizable(false);
            jtableLivros.getColumnModel().getColumn(3).setPreferredWidth(70);
            jtableLivros.getColumnModel().getColumn(3).setResizable(false);
            jtableLivros.getTableHeader().setReorderingAllowed(false);
            jtableLivros.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
            jtableLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtableLivros.setRowHeight(50);

        } else if (jtable == jtableLivros02) {
            jtableLivros02.setModel(modeltable);
            jtableLivros02.getColumnModel().getColumn(0).setPreferredWidth(350);
            jtableLivros02.getColumnModel().getColumn(0).setResizable(false);
            jtableLivros02.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtableLivros02.getColumnModel().getColumn(1).setResizable(false);
            jtableLivros02.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtableLivros02.getColumnModel().getColumn(2).setResizable(false);
            jtableLivros02.getColumnModel().getColumn(3).setPreferredWidth(70);
            jtableLivros02.getColumnModel().getColumn(3).setResizable(false);
            jtableLivros02.getTableHeader().setReorderingAllowed(false);
            jtableLivros02.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
            jtableLivros02.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtableLivros02.setRowHeight(50);
        } else {
            jtableLivros03.setModel(modeltable);
            jtableLivros03.getColumnModel().getColumn(0).setPreferredWidth(350);
            jtableLivros03.getColumnModel().getColumn(0).setResizable(false);
            jtableLivros03.getColumnModel().getColumn(1).setPreferredWidth(80);
            jtableLivros03.getColumnModel().getColumn(1).setResizable(false);
            jtableLivros03.getColumnModel().getColumn(2).setPreferredWidth(70);
            jtableLivros03.getColumnModel().getColumn(2).setResizable(false);
            jtableLivros03.getColumnModel().getColumn(3).setPreferredWidth(70);
            jtableLivros03.getColumnModel().getColumn(3).setResizable(false);
            jtableLivros03.getTableHeader().setReorderingAllowed(false);
            jtableLivros03.setAutoResizeMode(jtable.AUTO_RESIZE_OFF);
            jtableLivros03.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jtableLivros03.setRowHeight(50);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelNomeDisciplina = new javax.swing.JLabel();
        jbuttonVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtableLivros = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableLivros02 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtableLivros03 = new javax.swing.JTable();
        labelNomeDisciplina02 = new javax.swing.JLabel();
        labelNomeDisciplina03 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Livros Sugeridos");
        setPreferredSize(new java.awt.Dimension(1289, 615));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Bookle Sistema Acadêmico");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Curso selecionado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText(telapesquisar.getResNomecurso());

        labelNomeDisciplina.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNomeDisciplina.setText(telapesquisar.getResNomedisciplina());

        jbuttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bookleprojeto/imagensBookle/back.png"))); // NOI18N
        jbuttonVoltar.setText("Voltar");
        jbuttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonVoltarActionPerformed(evt);
            }
        });

        jtableLivros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jtableLivros);

        jtableLivros02.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableLivros02.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtableLivros02);

        jtableLivros03.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtableLivros03.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jtableLivros03);

        labelNomeDisciplina02.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNomeDisciplina02.setText(telapesquisar.getResNomedisciplina02());

        labelNomeDisciplina03.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        labelNomeDisciplina03.setText(telapesquisar.getResNomedisciplina03());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(381, 381, 381))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbuttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelNomeDisciplina02, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelNomeDisciplina03, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(42, 42, 42))))
                        .addGap(329, 329, 329))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addComponent(labelNomeDisciplina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelNomeDisciplina02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(labelNomeDisciplina03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbuttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1289, 629);
    }// </editor-fold>//GEN-END:initComponents

    private void jbuttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_jbuttonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbuttonVoltar;
    private javax.swing.JTable jtableLivros;
    private javax.swing.JTable jtableLivros02;
    private javax.swing.JTable jtableLivros03;
    private javax.swing.JLabel labelNomeDisciplina;
    private javax.swing.JLabel labelNomeDisciplina02;
    private javax.swing.JLabel labelNomeDisciplina03;
    // End of variables declaration//GEN-END:variables
}
