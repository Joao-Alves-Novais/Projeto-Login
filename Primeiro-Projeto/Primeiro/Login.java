

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Login implements ActionListener {
	
	static int s = 1;
	static int u = 1;
	
	JFrame frame;
	JLabel L1, L2, L3;
	JTextField usuario;
	JPasswordField senha, senha2;
	JButton entrar, criarConta, voltar, criar, dados, entrar2;
	JTable tabela;
	JScrollPane rolagem;
	Robot robo;
	
	//BANCO DE DADOS (LISTA COM USUARIOS E SENHAS)
	List<String> Usuarios = new ArrayList<String>();
	List<String> Senhas = new ArrayList<String>();

	//TABELA COM TODOS OS CADASTROS
	String data[][]  = new String[50][2];   
	String column[]  = {"n", "s"};
	
	
	public Login() {
		
		data[0][0] = "              USUARIO:"; data[0][1]="              SENHA:";		
		
		//CRIANDO UMA PAGINA
		frame = new JFrame("ENTRAR");
		
		//TEXTO USUARIO
		L1 = new JLabel("USUARIO:");
		L1.setBounds(50, 25, 100, 20);
		
		//CAIXA DE TEXTO DO USUARIO
		usuario = new JTextField();
		usuario.setBounds(110, 25, 125, 20);
		
		//TEXTO SENHA
		L2 = new JLabel("SENHA:");
		L2.setBounds(50, 50, 100, 20);
		
		// CAIXA DE TEXTO DA SENHA
		senha = new JPasswordField();
		senha.setBounds(110, 50, 125, 20);
		
		//BOTÃO ENTRAR
		entrar = new JButton("ENTRAR");
		entrar.setBounds(110, 75, 125, 20);
		
		//BOTÃO VERIFICAR
		entrar2 = new JButton("VERIFICAR");
		entrar2.setBounds(110, 75, 125, 20);
		
		//POSIÇÃO DO TEXTO QUE MOSTRA SE ENTROU OU NÃO
		L3 = new JLabel();
		L3.setBounds(115, 100, 125, 20);
		
		//BOTÃO CRIAR CONTA
		criarConta = new JButton("CRIAR CONTA");
		criarConta.setBounds(110, 125, 125, 20);
		
		//BOTÃO DADOS
		dados = new JButton("DADOS");
		dados.setBounds(110, 150, 125, 20);
		
		//BOTÃO CRIAR
		criar = new JButton("CRIAR");
		
		//BOTÃO VOLTAR
		voltar = new JButton("VOLTAR");
		
		//NÃO SEI PRA QUE SERVE (MAS SÓ FUNCIONA ASSIM)
		rolagem = new JScrollPane(tabela = new JTable(data, column));

		
		//FUNCÕES DO BOTÃO AO SER CLICADO
		entrar.addActionListener(this);
		criarConta.addActionListener(this);
		criar.addActionListener(this);
		voltar.addActionListener(this);
		dados.addActionListener(this);
		entrar2.addActionListener(this);
		
		//ADICIONANDOCOMPONETES NA PAGINA
		frame.add(L1);   	frame.add(usuario); 		
		frame.add(L2);   	frame.add(senha);	
							frame.add(entrar);
							frame.add(L3);
						 	frame.add(criarConta);
						 	frame.add(dados);
						 	frame.add(criar);
						 	frame.add(voltar);
						 	frame.add(entrar2);
						 	frame.add(tabela);
						 	


						 
		
		//CARACTERISTICAS DA PAGINA
		frame.setSize(350,300);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//PEGANDO AS INFORMAÇÕES DO USUARIO E SENHA
		String usuario2 = usuario.getText();
		@SuppressWarnings("deprecation")
		String senha2 = senha.getText();
		
		//DEFININDO FUNCIONALIDADES DO BOTÃO ENTRAR
		if(e.getSource() == entrar) {
			for(int u=0; u<Senhas.size(); u++) {
				
				//SE O USUARIO E SENHA CONTER NA LISTA ELE ENTRA
				if(usuario2.equalsIgnoreCase(Usuarios.get(u)) && senha2.equalsIgnoreCase(Senhas.get(u))) {
					//DEFININDO COR E TEXTO A SER MOSTRADO
					L3.setBounds(115, 100, 125, 20);
					L3.setForeground(Color.blue);
					L3.setText("SEJA BEM VINDO!");
					
					try {
						robo = new Robot();
					} catch (AWTException e2) {
						e2.printStackTrace();
					}
					robo.delay(2000);
					// ABRE O BROWSER MICROSOFT EDGE
					String command = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"";   
					Runtime run = Runtime.getRuntime();   
					try {
						run.exec(command);
					} catch (IOException e1) {
						e1.printStackTrace();
					} 
					break;
				//SE UM DOS CAMPOS ESTIVER VAZIO
				}else if(usuario2.equalsIgnoreCase("") || senha2.equalsIgnoreCase("")) {
					//DEFININDO COR E TEXTO A SER MOSTRADO
					L3.setBounds(115, 100, 125, 20);
					L3.setForeground(Color.black);
					L3.setText("CAMPO(S) VAZIO(S).");
				//COMO ÚLTIMO CASO, USUARIO E SENHA ESTARÃO ERRADOS
				}else{
					//DEFININDO COR E TEXTO A SER MOSTRADO
					L3.setBounds(115, 100, 125, 20);
					L3.setForeground(Color.red);
					L3.setText("INCORRETO.");
				}
			}
		}
		//DEFININDO FUNCIONALIDADES DO BOTÃO CRIAR CONTA
		else if(e.getSource() == criarConta) {
			//MUDANDO LABEL DE USUARIO E SENHA
			frame.setTitle("CADASTRO");
			L1.setText("NOVO USUARIO:");
			L2.setText("NOVA SENHA:");
			L3.setText("");
			L3.setBounds(150, 100, 125, 20);
			
			//MUDANDO POSIÇÃO DA CAIXA DE TEXTO DO USUARIO E SENHA
			usuario.setBounds(150, 25, 125, 20);
			senha.setBounds(150, 50, 125, 20);
			
			//REMOVENDO BOTÃO VERIFICAR
			entrar2.setBounds(0,0,0,0);
			
			//TIRANDO O BOTÃO ENTRAR
			entrar.setBounds(0, 0, 0, 0);
			
			//TIRANDO O BOTÃO CRIAR CONTA
			criarConta.setBounds(0, 0, 0, 0);
			
			//TIRANDO O BOTÃO CRIAR CONTA
			dados.setBounds(0,0,0,0);
			
			//POSICIONANDO BOTÃO VOLTAR E BOTÃO CRIAR
			voltar.setBounds(150, 125, 125, 20);
			criar.setBounds(150, 75, 125, 20);
			
		}
		//DEFININDO FUNCIONALIDADES DO BOTÃO CRIAR 
		else if(e.getSource() == criar) {
			boolean existe = false;
			//VERIFICANDO SE OS CAMPOS ESTÃO VAZIOS
			if(usuario2.equalsIgnoreCase("") || senha2.equalsIgnoreCase("")) {
				//DEFININDO COR E TEXTO A SER MOSTRADO
				L3.setForeground(Color.black);
				L3.setText("CAMPO(S) VAZIO(S).");
				
			}else {
				//VERIFICANDO SE A CONTA JA EXISTE
				for(int s=0; s<Usuarios.size(); s++) {
					if(usuario2.equalsIgnoreCase(Usuarios.get((s))) && senha2.equalsIgnoreCase(Senhas.get((s)))) {
						//DEFININDO COR E TEXTO A SER MOSTRADO
						L3.setForeground(Color.red);
						L3.setText("CONTA EXISTENTE!");
						existe = true;
						break;
					}	
				}//ADICIONANDO CONTA AO "BANCO DE DADOS" CASO NÃO EXISTA
				if(!existe) {
					//DEFININDO COR E TEXTO A SER MOSTRADO
					L3.setForeground(Color.blue);
					L3.setText("CONTA CRIADA.");
					Usuarios.add((u-1), usuario2); Senhas.add((u-1), senha2);
					data[s][0] = Usuarios.get(u-1).toUpperCase(); data [s][1] = Senhas.get(u-1);
					s++;
				}
			}
		}

		//DEFININDO AS FUNCIONALIDADES DO BOTÃO VOLTAR
		else if(e.getSource() == voltar) {
			
			//MUDANDO LABEL DE NOVO USUARIO E NOVA SENHA
			frame.setTitle("ENTRAR");
			L1.setText("USUARIO:");
			L2.setText("SENHA:");
			L3.setText("");
			L3.setBounds(115, 100, 125, 20);
			
			//MUDANDO POSIÇÃO DA CAIXA DE TEXTO DO USUARIO E SENHA
			usuario.setBounds(110, 25, 125, 20);
			senha.setBounds(110, 50, 125, 20);
			
			//TIRANDO O BOTÃO CRIAR
			criar.setBounds(0, 0, 0, 0);
			
			//TIRADO O BOTÃO VOLTAR
			voltar.setBounds(0, 0, 0, 0);
			
			//POSICIONANDO BOTÃO ENTRAr, CRIAR CONTA E DADOS
			entrar.setBounds(110, 75, 125, 20);
			criarConta.setBounds(110, 125, 125, 20);
			dados.setBounds(110, 150, 125, 20);
			
			//TIRANDO A TABELA
			tabela.setBounds(0,0,0,0);
			
			//TIRANDO TEXTTO SUARIO E SENHA
			usuario.setText("");
			senha.setText("");
			
		}
		//DEFININDO FUNCIONALIDADES DO BOTÃO DADOS
		else if(e.getSource() == dados) {
			
			//TIRANDO LABEL DA PAGINA, USUARIO E SENHA
			frame.setTitle("CADASTROS");
			L1.setText("SENHA:");
			L2.setText("");
			L3.setText("");
			
			//TIRANDO A CAIXA DE TEXTO DO USUARIO E SENHA
			usuario.setBounds(0,0,0,0);
			senha.setBounds(110, 25, 125, 20);
			
			//TIRANDO O BOTÃO ENTRAR
			entrar2.setBounds(110, 75, 125, 20);
			entrar.setBounds(0, 0, 0, 0);
			voltar.setBounds(110, 100, 125, 20);
				
			//TIRADO O BOTÃO CRIAR CONTA
			criarConta.setBounds(0, 0, 0, 0);
			
			//TIRANDO BOTÃO DADOS
			dados.setBounds(0, 0, 0, 0);
		
		}
		
		//DEFININDO AS FUNCIONALIDADES DO BOTÃO VERIFICAR
		//SENHA DO "BANCO DE DADOS": 46441
		else if(e.getSource() == entrar2) {
			if(senha2.equalsIgnoreCase("46441")) {
				
				//TIRANDO LABEL DA PAGINA, USUARIO E SENHA
				frame.setTitle("CADASTROS");
				L1.setText("");
				L2.setText("");
				L3.setText("");

				
				//TIRANDO A CAIXA DE TEXTO DO USUARIO E SENHA
				usuario.setBounds(0, 0, 0, 0);
				senha.setBounds(0, 0, 0, 0);
				
				//TIRANDO O BOTÃO ENTRAR
				entrar.setBounds(0, 0, 0, 0);
				
				//ADICIONANDO BOTÃO VOLTAR
				voltar.setBounds(15, 200, 300, 20);
				
				//TIRADO O BOTÃO CRIAR CONTA
				criarConta.setBounds(0, 0, 0, 0);
				
				//TIRANDO BOTÃO DADOS
				dados.setBounds(0, 0, 0, 0);
				    
				//COLOCANDO UMA TABELA
			    tabela.setBounds(15,12,300,200);
			    
			    //TIRANDO BOTÃO VERIIFCAR
			    entrar2.setBounds(0,0,0,0);
			}
		}
	}
	
	public static void main(String[] args) {
		Login PL = new Login();

	}
}