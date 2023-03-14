////inicio menu de configuração     
//        //criar botão que recebe menuBar
//        JButton btnMenu = new JButton("");
//        btnMenu.setForeground(new Color(114, 144, 255));
//        btnMenu.setBackground(new Color(114, 144, 255));
//        btnMenu.setBorder(null);
//        btnMenu.setIcon(new ImageIcon(TelaConversorMoeda.class.getResource("/imgs/setting-2.png")));
//        btnMenu.setBounds(10, 10, 45, 45);
//        panel.add(btnMenu);        
//        
//        // Cria um menu
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setForeground(new Color(114, 144, 255));
//		menuBar.setBackground(new Color(114, 144, 255));
//		menuBar.setBorder(null);
//		btnMenu.add(menuBar);
//		 
//		 // Cria um menu 1 nome Opções
//	    JMenu opcoes = new JMenu("");
//	    opcoes.setBackground(new Color(114, 144, 255));
//	    opcoes.setForeground(new Color(102, 51, 153));
//		opcoes.setBorder(null);
//	    opcoes.setIcon(new ImageIcon(TelaConversorMoeda.class.getResource("/imgs/setting-2.png")));
//		
//		// Cria outro menu 2 nome ferramentas 
//	    JMenu temas = new JMenu("Themes"); 
//	    temas.setForeground(new Color(102, 51, 153));
//	    temas.setBorder(null);
//	    temas.setBackground(new Color(114, 144, 255));
//	    
//	    JMenu idiomas = new JMenu("Languages");
//	    idiomas.setForeground(new Color(102, 51, 153));
//	    idiomas.setBorder(null);
//	    idiomas.setBackground(new Color(255, 255, 255));
//	    
//	    // Adiciona o segundo JMenu ao primeiro
//	    opcoes.add(temas);
//	    opcoes.add(idiomas);
//	    
//	    // Cria itens de menu e o adiciona ao menu temas. 
//	    // noturno e violeta são sub menus do menu temas
//	    JMenuItem noturno = new JMenuItem("Dark Mode");
//	    noturno.setForeground(new Color(102, 51, 153));
//	    noturno.setBorder(null);
//	    noturno.setBackground(new Color(114, 144, 255));
//	    temas.add(noturno);
//	    JMenuItem violeta = new JMenuItem("Violet");
//	    violeta.setForeground(new Color(102, 51, 153));
//	    violeta.setBackground(new Color(114, 144, 255));
//	    violeta.setBorder(null);
//	    temas.add(violeta);
//	    
//	 // Cria itens de menu e o adiciona ao menu idiomas. 
//	 // portugues, inglês são sub menus do menu idiomas
//	    JMenuItem portugues = new JMenuItem("Portuguese");
//	    portugues.setForeground(new Color(102, 51, 153));
//	    portugues.setBorder(null);
//	    portugues.setBackground(new Color(114, 144, 255));
//	    idiomas.add(portugues);
//	    JMenuItem ingles = new JMenuItem("English");
//	    ingles.setBorder(null);
//	    ingles.setBackground(new Color(114, 144, 255));
//	    ingles.setForeground(new Color(102, 51, 153));
//	    idiomas.add(ingles);
//	    
//	 // Adiciona o menu à barra de menus
//	    menuBar.add(opcoes);
////Fim Menu opcoes	    