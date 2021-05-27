package entidades;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField recebeIdade;
	private JTextField recebeAltura;
	private JTextField recebePeso;
	private JLabel jIdade;
	private JLabel jAltura;
	private JLabel jPeso;
	private JLabel jSexo;
	private JLabel jFator;
	private JComboBox<Object> listaFator;
	private JComboBox<Object> listaSexo;
	private JButton Calcular;
	private JButton Limpar;

    String exibiFator[] = {"Sedentário(a)", "Básica", "Leve", "Moderada", "Intensa"};
    String exibiSexo[] = {"Masculino", "Feminino"};

    int idade = 0;
	int fator = 0;
	int verificaIdade = 0;
	double altura = 0;
	double peso = 0;
	double resultadoIMC = 0;
	double resultadoPesoIdeal = 0;
	double resultadoTaxaMetabolica = 0;
	String sexo = "";
	String resultadoSituacao = "";

	public Interface() throws ParseException {

    	this.setTitle("Peso Ideal");
    	this.setBounds(0, 0, 350, 280);
    	this.setLocationRelativeTo(null);

    	JPanel painel = new JPanel();
    	this.setContentPane(painel);
    	painel.setLayout(null);

    	jAltura = new JLabel("Altura:              m.");
    	jAltura.setBounds(50, -20, 120, 120);
    	painel.add(jAltura);
    	recebeAltura = new JFormattedTextField(new MaskFormatter("#.##"));
    	recebeAltura.setBounds(95, 30, 30, 20);
    	painel.add(recebeAltura);

    	jPeso = new JLabel("Peso:                 kg.");
    	jPeso.setBounds(170, -20, 120, 120);
    	painel.add(jPeso);
    	recebePeso = new JFormattedTextField();
    	recebePeso.setBounds(210, 30, 40, 20);
    	painel.add(recebePeso);
    	
    	jIdade = new JLabel("Idade:");
    	jIdade.setBounds(50, 20, 120, 120);
    	painel.add(jIdade);
    	recebeIdade = new JFormattedTextField(new MaskFormatter("##"));
    	recebeIdade.setBounds(95, 70, 30, 20);
    	painel.add(recebeIdade);

    	jSexo = new JLabel ("Sexo:");
    	jSexo.setBounds(150, 20, 120, 120);
    	painel.add(jSexo);
    	listaSexo = new JComboBox<Object>(exibiSexo);
    	listaSexo.setBounds(195, 70, 85, 20);
    	painel.add(listaSexo);

    	jFator = new JLabel ("Fator de Atividade:");
    	jFator.setBounds(50, 60, 120, 120);
    	painel.add(jFator);
    	listaFator = new JComboBox<Object>(exibiFator);
    	listaFator.setBounds(170, 110, 110, 20);
    	painel.add(listaFator);

    	Calcular = new JButton("Calcular");
    	Calcular.setBounds(185, 165, 85, 30);
    	painel.add(Calcular);
    	
    	Limpar = new JButton("Limpar");
    	Limpar.setBounds(65, 165, 85, 30);
    	painel.add(Limpar);

    	Calcular.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			
    			sexo = (String) listaSexo.getSelectedItem();
    			fator = listaFator.getSelectedIndex();

    			try {
    				altura = Double.parseDouble(recebeAltura.getText());
    			} catch (NumberFormatException Erro1) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha o campo Altura!\n\n");
    				recebeAltura.setText("");
    				altura = 0;
    			}
    			
    			try {
    				peso = Double.parseDouble(recebePeso.getText());
    			} catch (NumberFormatException Erro2) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha o campo Peso!\nExemplo: 75.9\n\n");
    				recebePeso.setText("");
    				peso = 0;
    			}
    				
    			try {
    				idade = Integer.parseInt(recebeIdade.getText());
    			} catch (NumberFormatException Erro3) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha o campo Idade!\n\n");
    				recebeIdade.setText("");
    				idade = 0;
    			}

    			if (idade >= 1 && idade <= 2 || idade >= 11 && idade <= 17) {
    				JOptionPane.showMessageDialog(null,"\nIdade não se enquadra nos critérios.\n\nFaixa Etária Coberta.\nCrianças: 03 a 10 anos.\nAdultos: 18 a  64 anos."
    											  + "\nIdosos: Acima de 65 anos.\n\nInsira novamente a idade!\n\n");
    				recebeIdade.setText("");
    			} else if ((idade >= 3 && idade <=10) || (idade >= 18) && peso > 0) {
    					resultadoIMC = calculoPeso.imc (altura, peso);
    					resultadoSituacao = calculoPeso.condicaoIMC(resultadoIMC);
        				resultadoPesoIdeal = calculoPeso.pesoIdeal(idade, altura, sexo);
        				resultadoTaxaMetabolica = calculoMetabolico.taxaMetabolica(idade, peso, sexo, fator);

        				JOptionPane.showMessageDialog(null,"\nIMC :  " +resultadoIMC+ " kg/m2.\nSituação :  " +resultadoSituacao+ ".\n\nPeso Ideal :  " +resultadoPesoIdeal+
        										  " kg.\nTMB Recomendada :  " +resultadoTaxaMetabolica+ " Kcal.          \n\n");
				}
        	}
    	});
    	
    	Limpar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt ) {

    			idade = (int) (altura = peso = 0);
    			recebeAltura.setText("");
    			recebePeso.setText("");
    			recebeIdade.setText("");

    			//Campo preenchido para teste.
    			/*recebeAltura.setText("1.73");
    			recebePeso.setText("75.0");
    			recebeIdade.setText("27");*/
    		}
    	});
    }
}
