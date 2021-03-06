// modificar carga utilizar area

package Individuos;

import java.util.ArrayList;
import java.util.Scanner;

import funcional.Prestaciones;
import funcional.Turno;

public class Medico {

	private long matricula;
	private String nombre, apellido;

	public Medico() {

		this.matricula = 0;
		this.nombre = null;
		this.apellido = null;

	}
	
	public void mostrar()
	{
		System.out.println("Matricula: "+matricula);
		System.out.println("Nombre: "+nombre);
		System.out.println("Apellido: "+apellido);
	}

	public long getMatricula() {
		return matricula;
	}

	private void Ingresarmatricula() {
		boolean salir=false;
		while(!salir){
		try {
		System.out.println("Ingrese matricula del medico");
		Scanner Ss = new Scanner(System.in);
		long Ingreso = Ss.nextLong();
		this.matricula = Ingreso;
		salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}
	}

	private void Ingresarnombre() {
		boolean salir=false;
		while(!salir){
		try {
		System.out.println("ingrese nombre del medico");
		Scanner Ss = new Scanner(System.in);
		String Ingreso = Ss.nextLine();
		this.nombre = Ingreso;
		salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}

	}

	private void Ingresarapellido() {
		boolean salir=false;
		while(!salir){
		try {
		System.out.println("ingrese apellido del medico");
		Scanner Ss = new Scanner(System.in);
		String Ingreso = Ss.nextLine();
		this.apellido = Ingreso;
		salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}

	}

	private void Ingresararemedica() {
		boolean salir=false;
		while(!salir){
		try {
		// pensarlo mejor
		System.out.println("igrese el areamedica");
		Scanner Ss = new Scanner(System.in);
		String Ingreso = Ss.nextLine();
		salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}

	}

	public boolean Buscarmedico(long matricula, ArrayList<Medico> listamedico) {
		for (Medico e : listamedico) {
			if (e.matricula == matricula) {
				return true;
			}

		}

		return false;
	}

	public Medico Devolvermedico(long matricula, ArrayList<Medico> listamedico) {
		for (Medico e : listamedico) {

			if (e.matricula == matricula) {
				return e;
			}
		}
		return null;
	}

	public void Altamedico(long matricula, ArrayList<Medico> listamedico) {

		Medico medico = new Medico();

		// controlar y mejorar

		if (medico.Buscarmedico(matricula, listamedico)) {
			
			System.out.println("El medico ya existe");

		} else {
			medico.matricula=matricula;
			medico.Ingresarnombre();
			medico.Ingresarapellido();

			listamedico.add(medico);
			
			System.out.println("medico cargado con exito");
			

		}
		
	}

	public ArrayList<Medico> Modificacionmedico(long matricula, ArrayList<Medico> listamedico) {

		Medico medico = new Medico();

		if (Buscarmedico(matricula, listamedico)) {

			medico = this.Devolvermedico(matricula, listamedico);

			listamedico.remove(medico);

			Scanner Sc = new Scanner(System.in);
			int opcion = 0;

			do {

				System.out.println("opcion 1: modificar matricula");
				System.out.println("opcion 2: modificar nombre");
				System.out.println("opcion 3: modificar apellido");
				System.out.println("0: para salir");
				opcion = Sc.nextInt();
				switch (opcion) {

				case 1:
					medico.Ingresarmatricula();
					break;
				case 2:
					medico.Ingresarnombre();
					break;
				case 3:
					medico.Ingresarapellido();
					break;

				}
			} while (opcion != 0);

			listamedico.add(medico);

			System.out.println("medico modificado con exito");
			return listamedico;

		}

		else {
			System.out.println("no existe, primero registre al paciente");
			return listamedico;
		}

	}

	public ArrayList<Medico> Bajamedico(long matricula, ArrayList<Medico> listamedico) {

		Medico medico = new Medico();

		if (Buscarmedico(matricula, listamedico)) {

			medico = this.Devolvermedico(matricula, listamedico);

			listamedico.remove(medico);

			return listamedico;
		}

		else {
			System.out.println("El paciente que deseea remover no existe");
			return listamedico;
		}

	}

	public void Cargarestudios(ArrayList<Paciente> listapaciente) 
	{
		int idpaciente=0;
		String ingreso=null;
		boolean salir=false;
		while(!salir){
		try {
			Scanner Sc = new Scanner(System.in);
	
			System.out.println("ingrese id paciente");
			 idpaciente= Sc.nextInt();
			
			System.out.println("ingrese estudio a realizar");
			 ingreso=Sc.nextLine();
			
			salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}
		
			for(Paciente e : listapaciente)
			{
				if(e.getIdpaciente()==idpaciente)
				{
					
					e.setEstudios(ingreso);
					
				}
			}

					
		
		
	}

	public void Cargarrecetas(ArrayList<Paciente> listapaciente) 
	{
		int idpaciente=0;
		String ingreso=null;
		boolean salir=false;
		while(!salir){
		try {
		
		Scanner Sc = new Scanner(System.in);
		
		System.out.println("ingrese id paciente");
		 idpaciente= Sc.nextInt();
		
		System.out.println("ingrese receta");
		 ingreso=Sc.nextLine();
		 salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}
		for(Paciente e : listapaciente)
		{
			if(e.getIdpaciente()==idpaciente)
			{
				
				e.setEstudios(ingreso);
				
			}
		}

		
		
	}

	public void asistencia(ArrayList<Areamedica> listaarea, ArrayList<Paciente> listapaciente,ArrayList<Prestaciones> listaprestacion) {
		Prestaciones prestacion = new Prestaciones();
		Paciente pasiente = new Paciente();
		Scanner Sc = new Scanner(System.in);
		
		String ingreso=null;
		Long matricula = null;
		int idpaciente=0,idpaciente1=0,idturno=0;
		
		boolean salir=false;
		while(!salir){
		try {

		System.out.println("ingrese su area");
		 ingreso = Sc.nextLine();

		System.out.println("ingre su matricula");
		 matricula = Sc.nextLong();

		System.out.println("ingrese el id paciente");
		idpaciente1 = Sc.nextInt();

		System.out.println("ingrese id del turno");
		idturno = Sc.nextInt();
		salir=true;
		}

		catch(Exception e)
			{
				System.out.println("algo salio mal");
			}
			}

		boolean confirmar = false;
		if (pasiente.Buscarpaciente(idpaciente1, listapaciente)) {
			pasiente = pasiente.Devolverpaciente(idpaciente1, listapaciente);

		}

		for (Turno i : pasiente.getTurno()) {

			if (i.getIdturno() == idturno) {
				i.setAsistio(true);
				prestacion.setTurno(i);
				confirmar = true;
			}

		}

		for (Areamedica e : listaarea) {

			if (e.getArea() == ingreso) {

				if (e.Buscarmedico(matricula, e.getMedico())) {
					prestacion.setMedico(e.Devolvermedico(matricula, e.getMedico()));

					if (confirmar == true) {
						listaprestacion.add(prestacion);
					}

				} else {
					System.out.println("sos un medico?");
				}
			} else {
				System.out.println("no existe el area o esta mal escrita " + ingreso);
			}
		}

	}
	
	

}
