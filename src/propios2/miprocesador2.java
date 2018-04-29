package propios2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;



public class miprocesador2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MenuProcesador_II mimarco=new MenuProcesador_II();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

}

class MenuProcesador_II extends JFrame{
	
	public MenuProcesador_II(){
		
		setBounds(500,300,550,400);
		
		LaminaProcesador_II milamina=new LaminaProcesador_II();
		
		add(milamina);
		
		setVisible(true);
		
	}

}

class LaminaProcesador_II extends JPanel{
	
	public LaminaProcesador_II(){
		
		setLayout(new BorderLayout());
		
		JPanel laminamenu=new JPanel();
		
		JMenuBar mibarra=new JMenuBar();
				
		fuente=new JMenu("Fuente");
		
		estilo=new JMenu("Estilo");
		
		tamagno=new JMenu("Tamaño");
		
		
		
		configura_menu("Arial","fuente","Arial",9,10);
		
		configura_menu("Courier","fuente","Courier",9,10);
		
		configura_menu("Verdana","fuente","Verdana",9,10);
		
		configura_menu("Negrita","estilo","",Font.BOLD,1);
		
		configura_menu("Cursiva","estilo","",Font.ITALIC,1);
		
		configura_menu("12","tamaño","",9,12);
		
		configura_menu("16","tamaño","",9,16);
		
		configura_menu("20","tamaño","",9,20);
		
		configura_menu("24","tamaño","",9,24);
		
		
		mibarra.add(fuente);
		
		mibarra.add(estilo);
		
		mibarra.add(tamagno);
		
		laminamenu.add(mibarra);
		
		add(laminamenu, BorderLayout.NORTH);
		
		
		miarea=new JTextPane();
		
		add(miarea, BorderLayout.CENTER);
	
		
	}
	
	public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
		
		JMenuItem elem_menu=new JMenuItem(rotulo);
		
		if(menu=="fuente"){
			
			fuente.add(elem_menu);
			
		}else if (menu=="estilo"){
			
			estilo.add(elem_menu);
		
		}else if (menu=="tamaño"){
			
			tamagno.add(elem_menu);
		}
	
	
		elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam ));
	
	}
	
	private class Gestiona_Eventos implements ActionListener{

		String  rotulo2, tipo_letra2;
		
		int estilos2, tam2;
		
	
		public Gestiona_Eventos( String rotulo, String tipo_letra, int estilos, int tam){
			
			rotulo2=rotulo;
			
			tipo_letra2= tipo_letra;
			
			estilos2= estilos;
			
			tam2=tam;

		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			letras=miarea.getFont();
						
			if(rotulo2=="Arial"|| rotulo2=="Courier" || rotulo2=="Verdana"){
					
				estilos2=letras.getStyle();
				
				tam2=letras.getSize();
			
			}else if(rotulo2=="Cursiva" || rotulo2=="Negrita"){
				
				if(letras.getStyle()== 1 || letras.getStyle()== 2) {
					
					estilos2=3;
				}
			
				tipo_letra2= letras.getFontName();
				
				tam2=letras.getSize() ;
			
			}else if(rotulo2=="12" || rotulo2=="16"  || rotulo2=="20" || rotulo2=="24"){
				
				tipo_letra2=letras.getFontName();
				
				estilos2=letras.getStyle();
				
			}

			miarea.setFont(new Font(tipo_letra2, estilos2, tam2));
			
			System.out.println("Tipo: " + tipo_letra2 + " Estilo: " + estilos2 + " Tamaño: " + tam2);
			
		}
		
		
					
	}
	
	 JTextPane miarea;
	
	 JMenu fuente, estilo, tamagno;
	
	 Font letras;
	
}
