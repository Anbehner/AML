package de.ovgu.mb.iaf.model.adapter.AMLTree;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.tree.TreeNode;

import de.ovgu.mb.iaf.data.caex.RoleClassType;
import de.ovgu.mb.iaf.data.caex.SystemUnitClassType;
import de.ovgu.mb.iaf.model.application.ITreeNodeAdapter;

public class SupportedRoleClassAdapter implements ITreeNodeAdapter {
	
	SystemUnitClassType.SupportedRoleClass wrappedelement;
	
	public  SupportedRoleClassAdapter(SystemUnitClassType.SupportedRoleClass element) {
		wrappedelement = element; 
	
	}

	@Override
	public Enumeration children() {
		return new Vector<>().elements();
	}

	@Override
	public boolean getAllowsChildren() {
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		return null;
	}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		return 0;
	}

	@Override
	public TreeNode getParent() {
		
		
		return (TreeNode) amlTreeAdapterFactory.getInstance().getAdapter(wrappedelement.getParent(), TreeNode.class);
	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public Object getInternalObject() {
		return wrappedelement;
	}

	@Override
	public String getLabel() {
		return wrappedelement.getRefRoleClassPath();
	}

}
