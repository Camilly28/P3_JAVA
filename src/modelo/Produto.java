package modelo;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import apresentacao.TelaProduto;
public class Produto extends JFrame
{
	//atributos
		private int codigo;
		private String nome;
		private int quantidade;
		private float preco;
		//private Object JOptionPane;
		
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public float getPreco() {
			return preco;
		}
		public void setPreco(float preco) {
			this.preco = preco;
		}
			
			public Produto(int cd,String nm,int qt,float pr)
			{	codigo = cd;
				nome = nm;
				quantidade = qt;
				preco = pr;
				
			}
		

}
