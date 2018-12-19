package de.ovgu.mb.iaf.model.adapter.AMLTree;

import de.ovgu.mb.iaf.data.caex.InternalElementType;
import de.ovgu.mb.iaf.data.caex.RoleClassType;
import de.ovgu.mb.iaf.data.caex.SystemUnitClassType;
import de.ovgu.mb.iaf.model.adapters.AbstractObjectAdapterFactory;
import de.ovgu.mb.iaf.model.adapters.IAdapter;

public class amlTreeAdapterFactory extends AbstractObjectAdapterFactory {

	private static final amlTreeAdapterFactory instance = new amlTreeAdapterFactory();

	private amlTreeAdapterFactory() {

	}

	// nur ein Objekt der Klasse
	public static amlTreeAdapterFactory getInstance() {
		return instance;
	}

	@Override
	public Package adaptedPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> interfaceAdapted() {
		// TODO Auto-generated method stub
		return null;
	}

	// prüfen Objekt und ob es einen type gibt
	@Override
	public IAdapter getAdapter(Object objectToAdapt, Class<?> type) {
		// TODO Auto-generated method stub
System.out.println(objectToAdapt.getClass()+ " Klasse geAtdapter "+ objectToAdapt.hashCode());
		if (objectToAdapt instanceof InternalElementType) {
			
//			<SupportedRoleClass RefRoleClassPath="Graphenlib/Knoten" />
			if(((InternalElementType) objectToAdapt).getSupportedRoleClass().get(0).getRefRoleClassPath().equals("Graphenlib/Knoten")) 
				System.out.println("toll");
			System.out.println("erster teil: " + ((InternalElementType) objectToAdapt).getSupportedRoleClass().get(0).getRefRoleClassPath());
			
			return new InternalElementTreeAdapter((InternalElementType) objectToAdapt);

		}

		if (objectToAdapt instanceof SystemUnitClassType.SupportedRoleClass) {
			System.out.println("AdapterFactory: getRoleClassAdapter ");
			return new SupportedRoleClassAdapter((SystemUnitClassType.SupportedRoleClass) objectToAdapt);
		}
		return super.getAdapter(objectToAdapt, type);
	}

}
