package programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

import entidades.CalculoPeso;
import entidades.CalculoMetabolico;

public class Janela extends JFrame {

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
	private JButton jCalcular;
	private JButton jLimpar;

    String[] exibiFator = {"Sedentário(a)", "Básica", "Leve", "Moderada", "Intensa"};
    String[] exibiSexo= {"Masculino", "Feminino"};

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

	public Janela() throws ParseException {

    	this.setTitle("Calculadora Peso Ideal");
    	this.setBounds(0, 0, 350, 280);
    	this.setResizable(false);
    	this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    	var painel = new JPanel();
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
    	recebePeso = new JFormattedTextField(new MaskFormatter("##.#"));
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

    	jCalcular = new JButton("Calcular");
    	jCalcular.setBounds(185, 165, 85, 30);
    	painel.add(jCalcular);
    	
    	jLimpar = new JButton("Limpar");
    	jLimpar.setBounds(65, 165, 85, 30);
    	painel.add(jLimpar);

    	jCalcular.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt) {
    			
    			sexo = (String) listaSexo.getSelectedItem();
    			fator = listaFator.getSelectedIndex();

    			try {
    				altura = Double.parseDouble(recebeAltura.getText());
    			} catch (NumberFormatException erroAltura) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha corretamente o campo Altura!\n\n");
    				recebeAltura.setText("");
    				altura = 0;
    			}
    			
    			try {
    				peso = Double.parseDouble(recebePeso.getText());
    			} catch (NumberFormatException erroPeso) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha corretamente o campo Peso!\nExemplo: 75.9\n\n");
    				recebePeso.setText("");
    				peso = 0;
    			}
    				
    			try {
    				idade = Integer.parseInt(recebeIdade.getText());
    			} catch (NumberFormatException erroIdade) {
    				JOptionPane.showMessageDialog(null,"\nPor favor preencha corretamente o campo Idade!\n\n");
    				recebeIdade.setText("");
    				idade = 0;
    			}

    			if (idade >= 1 && idade <= 2 || idade >= 11 && idade <= 17) {
    				JOptionPane.showMessageDialog(null,"\nIdade fora dos critérios.\n\nFaixa Etária Coberta.\nCrianças: 03 a 10 anos.\nAdultos: 18 a  64 anos.\nIdosos: Acima de 65 anos.\n\nInsira novamente a idade!\n\n");
    				recebeIdade.setText("");
    				
    			} else if ((idade >= 3 && idade <=10) || (idade >= 18) && peso > 0) {
    					resultadoIMC = CalculoPeso.imc (altura, peso);
    					resultadoSituacao = CalculoPeso.condicaoIMC(resultadoIMC);
        				resultadoPesoIdeal = CalculoPeso.pesoIdeal(idade, altura, sexo);
        				resultadoTaxaMetabolica = CalculoMetabolico.taxaMetabolica(idade, peso, sexo, fator);

        				JOptionPane.showMessageDialog(null,"Resultado:\n\nIMC :  " +resultadoIMC+ " kg/m2.\nSituação :  " +resultadoSituacao+ ".\nPeso Ideal :  " +resultadoPesoIdeal+
        										  " kg.\nTMB Recomendada :  " +resultadoTaxaMetabolica+ " Kcal.          \n\n");
				}
        	}
    	});
    	
    	jLimpar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent evt ) {

    			idade = 0;
    			altura = 0;
    			peso = 0;
    			recebeAltura.setText("");
    			recebePeso.setText("");
    			recebeIdade.setText("");
    		}
    	});
    }
}
