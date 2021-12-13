package com.unir.laboratorio_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField TextNombreMedicamento;
	private JTextField TextCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    private static boolean isAlphaNumeric(String s) {
        return s != null && s.isEmpty()!=true && s.isBlank()!=true && s.matches("^[a-zA-Z0-9]*$");
    }
    
    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
    
    private String getSelectedButton(javax.swing.ButtonGroup buttonGroup)
    {  
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SISTEMA DE PEDIDOS");
		lblNewLabel.setBounds(158, 0, 139, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del medicamento:");
		lblNewLabel_1.setBounds(19, 35, 160, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de medicamento:");
		lblNewLabel_1_1.setBounds(37, 70, 126, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cantidad:");
		lblNewLabel_1_1_1.setBounds(99, 105, 62, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sucursal:");
		lblNewLabel_1_1_1_1.setBounds(99, 226, 57, 24);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Nombre del distribuidor:");
		lblNewLabel_1_1_1_1_1.setBounds(10, 140, 150, 24);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		ButtonGroup ButtonGroupDistribuidor = new javax.swing.ButtonGroup();
		
		JRadioButton RadioCofarma = new JRadioButton("Cofarma");
		RadioCofarma.setBounds(188, 141, 109, 23);
		contentPane.add(RadioCofarma);
		
		JRadioButton RadioEmpsephar = new JRadioButton("Empsephar");
		RadioEmpsephar.setBounds(188, 167, 109, 23);
		contentPane.add(RadioEmpsephar);
		
		JRadioButton RadioCemefar = new JRadioButton("Cemefar");
		RadioCemefar.setBounds(188, 193, 109, 23);
		contentPane.add(RadioCemefar);
		
		ButtonGroupDistribuidor.add(RadioCofarma);
        ButtonGroupDistribuidor.add(RadioEmpsephar);
        ButtonGroupDistribuidor.add(RadioCemefar);
		
		JCheckBox CheckPrincipal = new JCheckBox("Farmacia Principal");
		CheckPrincipal.setBounds(188, 227, 160, 23);
		contentPane.add(CheckPrincipal);
		
		JCheckBox CheckSecundaria = new JCheckBox("Farmacia Secundaria");
		CheckSecundaria.setBounds(188, 253, 160, 23);
		contentPane.add(CheckSecundaria);
		
		TextNombreMedicamento = new JTextField();
		TextNombreMedicamento.setBounds(189, 35, 171, 24);
		contentPane.add(TextNombreMedicamento);
		TextNombreMedicamento.setColumns(10);
		
		TextCantidad = new JTextField();
		TextCantidad.setColumns(10);
		TextCantidad.setBounds(189, 105, 171, 24);
		contentPane.add(TextCantidad);
		
		JComboBox ComboTipoMedicamento = new JComboBox();
		ComboTipoMedicamento.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un tipo", "Analgesico", "Analeptico", "Anestesico", "Antiacido", "Antidepresivo", "Antibiotico"}));
		ComboTipoMedicamento.setSelectedIndex(0);
		ComboTipoMedicamento.setBounds(189, 70, 171, 24);
		contentPane.add(ComboTipoMedicamento);
		
		JButton BotonBorrar = new JButton("Borrar");
		BotonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextNombreMedicamento.setText("");
		        TextCantidad.setText("");
		        ButtonGroupDistribuidor.clearSelection();
		        ComboTipoMedicamento.setSelectedIndex(0);
		        CheckPrincipal.setSelected(false);
		        CheckSecundaria.setSelected(false);
			}
		});
		BotonBorrar.setBounds(90, 302, 99, 23);
		contentPane.add(BotonBorrar);
		
		JButton BotonConfirmar = new JButton("Confirmar");
		BotonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int error=0;
		        String description = "";
		        String direccionSucursalPrincipal="Calle de la Rosa n. 28";
		        String direccionSucursalSecundaria="Calle Alcazabilla n. 3";
		        
		        if(!isAlphaNumeric(TextNombreMedicamento.getText())){
		            error=1;
		            description ="El nombre del medicamento esta incorrecto";
		        }
		        
		        if(ComboTipoMedicamento.getSelectedIndex()==0){
		            error=1;
		            description ="No se ha seleccionado un tipo de medicamento";
		        }
		        
		        if(!isNumeric(TextCantidad.getText())){
		            error=1;
		            description ="El cantidad no es un numero entero positivo";
		        }
		        
		        //Validar Radio Buttons
		        if(getSelectedButton(ButtonGroupDistribuidor)==null){
		            error=1;
		            description ="No se ha seleccionado un distribuidor";
		        }
		        /*****/
		        
		        // validar checks
		        int contSucursal=0;
		        if(!CheckPrincipal.isSelected()){
		            contSucursal++;
		        }
		        if(!CheckSecundaria.isSelected()){
		            contSucursal++;
		        }
		        if(contSucursal==2){
		            error=1;
		            description ="No se ha seleccionado una sucursal";
		        }
		        /*****/
		        
		        JFrame ventana = new JFrame();
		        
		        if(error==1){
		            JLabel LabelDescription = new javax.swing.JLabel();
		            LabelDescription.setText(description);
		            Dimension size = LabelDescription.getPreferredSize();
		            LabelDescription.setBounds(130, 140, size.width, size.height);
		            LabelDescription.setBackground(Color.red);
		            LabelDescription.setVisible(true);
		            ventana.getContentPane().add(LabelDescription);
		        }else{
		            
		            JLabel LabelDistribuidor = new javax.swing.JLabel();
		            JLabel LabelMedicamento = new javax.swing.JLabel();
		            JLabel LabelDireccion = new javax.swing.JLabel();
		            JButton BotonConfirmarPedido = new javax.swing.JButton("Enviar Pedido");
		            JButton BotonCancelarPedido = new javax.swing.JButton("Cancelar Pedido");
		            
		            BotonConfirmarPedido.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                    System.out.println("Pedido Enviado");
		                    ventana.setVisible(false);
		                    /*
		                     Limpiar
		                    */
		                    TextNombreMedicamento.setText("");
		    		        TextCantidad.setText("");
		    		        ButtonGroupDistribuidor.clearSelection();
		    		        ComboTipoMedicamento.setSelectedIndex(0);
		    		        CheckPrincipal.setSelected(false);
		    		        CheckSecundaria.setSelected(false);
		                }
		            });
		            
		            BotonCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                    ventana.setVisible(false);
		                    /*
		                     Limpiar
		                    */
		                    TextNombreMedicamento.setText("");
		    		        TextCantidad.setText("");
		    		        ButtonGroupDistribuidor.clearSelection();
		    		        ComboTipoMedicamento.setSelectedIndex(0);
		    		        CheckPrincipal.setSelected(false);
		    		        CheckSecundaria.setSelected(false);
		                }
		            });
		            
		            
		            LabelDistribuidor.setText("Pedido al distribuidor "+getSelectedButton(ButtonGroupDistribuidor));
		            LabelMedicamento.setText(TextCantidad.getText()+" unidades del "+TextNombreMedicamento.getText()+" "+ComboTipoMedicamento.getSelectedItem().toString());
		            
		            if(CheckPrincipal.isSelected() && contSucursal==1){
		                LabelDireccion.setText("Para la farmacia situada en la "+ direccionSucursalPrincipal);
		            }
		            
		            if(CheckSecundaria.isSelected() && contSucursal==1){
		                LabelDireccion.setText("Para la farmacia situada en la "+ direccionSucursalSecundaria);
		            }
		            
		            if(contSucursal==0){
		                LabelDireccion.setText("<html>Para la farmacia situada en la  "+ direccionSucursalPrincipal+" <br/> y para la situada en la  "+direccionSucursalSecundaria+"</html>");
		            }
		            
		            
		            Dimension size = LabelDistribuidor.getPreferredSize();
		            LabelDistribuidor.setBounds(130, 140, size.width, size.height);
		            LabelDistribuidor.setVisible(true);
		            
		            size = LabelMedicamento.getPreferredSize();
		            LabelMedicamento.setBounds(130, 160, size.width, size.height);
		            LabelMedicamento.setVisible(true);
		            
		            size = LabelDireccion.getPreferredSize();
		            LabelDireccion.setBounds(130, 180, size.width, size.height);
		            LabelDireccion.setVisible(true);
		            
		            size = BotonCancelarPedido.getPreferredSize();
		            BotonCancelarPedido.setBounds(100, 250, size.width, size.height);
		            BotonCancelarPedido.setVisible(true);
		            
		            size = BotonConfirmarPedido.getPreferredSize();
		            BotonConfirmarPedido.setBounds(260,250 , size.width, size.height);
		            BotonConfirmarPedido.setVisible(true);
		            
		            ventana.getContentPane().add(LabelDistribuidor);
		            ventana.getContentPane().add(LabelMedicamento);
		            ventana.getContentPane().add(LabelDireccion);
		            
		            ventana.getContentPane().add(BotonCancelarPedido);
		            ventana.getContentPane().add(BotonConfirmarPedido);
		            
		        }
		        
		        ventana.getContentPane().setLayout(null);
		        ventana.setSize(476, 348);
		        ventana.setVisible(true);
			}
		});
		BotonConfirmar.setBounds(223, 302, 99, 23);
		contentPane.add(BotonConfirmar);
	}
}
