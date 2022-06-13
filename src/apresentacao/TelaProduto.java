package apresentacao;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

import apresentacao.TelaProduto;
import modelo.Produto;
public class TelaProduto extends JFrame
{


		
		//atributos comuns
		private JLabel lCodigo,lNome,lQuantidade,lPreco;
		private JTextField tCodigo,tNome,tQuantidade,tPreco;
		private JButton bCriarProduto,bMostrarProduto,bLimpar,bFechar,bSalvar;
		private JPanel painelTopo,painelCentral,painelInferior;
		private int screenHeight;
		private int screenWidth;
		
		//atributo de refer�ncia
		private Produto produto;
		
		//vari�veis locais para armazenar o que for digitado pelo usu�rio
		String codigo,nome,quantidade,preco;

		//m�todo construtor
		public TelaProduto()
		{
			//configura��es da janela TelaLivro
			this.setTitle("Tela de Gerenciamento de produto");
			Toolkit tk = Toolkit.getDefaultToolkit();
		    Dimension d = tk.getScreenSize();
		    screenHeight = d.height-400;
	        screenWidth = d.width-950;
	        this.setSize(screenWidth,screenHeight);
			this.setResizable(false);
			this.setLocationRelativeTo(null); //centraliza a janela na abertura
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); //fecha somente a janela ativa
			

			//captura da �rea �til da janela (container da janela)
			Container c = this.getContentPane();
					
			//defini��o do gerenciador de layout e aplica��o ao container da janela
			BorderLayout layout = new BorderLayout(5,5);
			c.setLayout(layout);
			
			//criando pain�is para estruturar as �reas na tela 
	        //cria um painel para o topo da janela com uma imagem e um t�tulo;
			//adiciona o painel ao container da janela em seu topo (parte supperior)
			JPanel painelSuperior = new JPanel();
			JLabel texto = new JLabel("     TELA DE PRODUTO");
			texto.setFont(new Font ("Arial",Font.BOLD,20));
			painelSuperior.add(texto);
			c.add(painelSuperior,BorderLayout.NORTH);	 
			 
			//cria um painel para o centro da janela
	        //defini��o do gerenciador de layout e aplica��o ao painel central da janela
			JPanel painelCentral = new JPanel();
			GridLayout layoutCentral = new GridLayout(5,2,5,5);
			painelCentral.setLayout(layoutCentral);

			//criando r�tulos e caixas de texto e adicionando-os
			//ao painel central de acordo com o gerenciador de layout definido 
			lCodigo = new JLabel("   CODIGO DE PRODUTO: ");
			lCodigo.setFont(new Font ("Arial",Font.BOLD,16));
			painelCentral.add(lCodigo);	
			
			tCodigo = new JTextField();
			painelCentral.add(tCodigo);

			lNome = new JLabel("   NOME DE PRODUTO: ");
			lNome.setFont(new Font ("Arial",Font.BOLD,16));
			painelCentral.add(lNome);	
			
			tNome = new JTextField();
			painelCentral.add(tNome);
			
			lQuantidade = new JLabel("   QUANTIDADE DE PRODUTO: ");
			lQuantidade.setFont(new Font ("Arial",Font.BOLD,16));
			painelCentral.add(lQuantidade);
			
			tQuantidade = new JTextField();
			painelCentral.add(tQuantidade);
					
			lPreco = new JLabel("   PRECO: ");
			lPreco.setFont(new Font ("Arial",Font.BOLD,16));
			painelCentral.add(lPreco);
			
			tPreco = new JTextField();
			painelCentral.add(tPreco);
			

			//cria um painel para o rodap� (parte inferior) da janela
	        //defini��o do gerenciador de layout e aplica��o ao painel inferior da janela
			JPanel painelInferior = new JPanel();
			GridLayout layoutInferior = new GridLayout(1,4,0,0);
			painelInferior.setLayout(layoutInferior);
			
			//criando classe interna para funcionar como ouvinte dos eventos de mouse
			class BatSinal extends MouseAdapter {
				public void mouseClicked(MouseEvent e) 
				{
					if (e.getSource() == bCriarProduto)
					{	codigo = tCodigo.getText();
						nome = tNome.getText();
						quantidade = tQuantidade.getText();
						preco = tPreco.getText();
						
						//Produto = new Produto(codigo,nome,quantidade,preco);
						JOptionPane.showMessageDialog(null,"Produto criado com sucesso!");
					}
									
					if (e.getSource() == bMostrarProduto)
					{	if(produto==null)
						{	JOptionPane.showMessageDialog(null,"Nao ha o que listar!");	}
						else
						{	JOptionPane.showMessageDialog(null,"DADOS DO PRODUTO:"
							+ "\nCodigo: "+produto.getCodigo()
							+ "\nNome: "+produto.getNome()
							+ "\nQuantidade: "+produto.getQuantidade()
							+ "\nPreco: "+produto.getPreco());
							
						}
					}	
									
					if (e.getSource() == bLimpar)
					{	tCodigo.setText("");
						tNome.setText("");
						tQuantidade.setText("");
						tPreco.setText("");
					
					}	
					
					if (e.getSource() == bFechar)
					{	dispose();	}
				}
			}
			
			//criando os bot�es e adicionando-os
			//ao painel inferior de acordo com o gerenciador de layout definido 
			bSalvar = new JButton("SALVAR ");
			bSalvar.setFont(new Font ("Arial",Font.BOLD,16));
			bSalvar.setForeground(Color.white);
			bSalvar.setBackground(new Color(3,101,173));
			
			painelInferior.add(bSalvar);
			
			bMostrarProduto = new JButton("MOSTRAR PRODUTO");
			bMostrarProduto.setFont(new Font ("Arial",Font.BOLD,16));
			bMostrarProduto.setForeground(Color.white);
			bMostrarProduto.setBackground(new Color(3,101,173));
			painelInferior.add(bMostrarProduto);

			bLimpar = new JButton("Limpar");
			bLimpar.setFont(new Font ("Arial",Font.BOLD,16));
			bLimpar.setForeground(Color.white);
			bLimpar.setBackground(new Color(3,101,173));
			
			painelInferior.add(bLimpar);
			
			bFechar = new JButton("Fechar");
			bFechar.setFont(new Font ("Arial",Font.BOLD,16));
			bFechar.setForeground(Color.white);
			bFechar.setBackground(new Color(3,101,173));
			
			painelInferior.add(bFechar);
						
			//adicionando os pain�is central e inferior
			//ao gerenciador de layout da tela livro nas posi��es centro e rodap�
			c.add(painelCentral,BorderLayout.CENTER);
			c.add(painelInferior,BorderLayout.SOUTH);
			
			this.repaint();
			this.setVisible(true);
		
	
					
					//------------------------------------------------------------------------------------------
					
					
					JPanel barraStatus = new JPanel();
					Date data = new Date();
			        SimpleDateFormat theFormat = new SimpleDateFormat("dd/MM/yyyy");
			        String dt = theFormat.format(data);
					JLabel status = new JLabel("SISLibrary - vers�o 1.0 - Devenvolvido por Camilly Duarte - Copyright (C) 2021 Todos os direitos reservados - Acesso realizado em "+dt);
					status.setFont(new Font ("Arial",Font.PLAIN,16));
					barraStatus.add(status);
					barraStatus.setBorder(BorderFactory.createLoweredBevelBorder());
					c.add(barraStatus,BorderLayout.SOUTH);
		}
}
