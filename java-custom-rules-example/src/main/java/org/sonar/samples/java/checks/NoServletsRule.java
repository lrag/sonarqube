package org.sonar.samples.java.checks;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.BaseTreeVisitor;
import org.sonar.plugins.java.api.tree.ClassTree;
import org.sonar.plugins.java.api.tree.TypeTree;

@Rule(key = "NoServlets")
public class NoServletsRule extends BaseTreeVisitor implements JavaFileScanner{

	private JavaFileScannerContext context;
	
	@Override
	public void scanFile(JavaFileScannerContext context) {
	    this.context = context;
	    scan(context.getTree());		
	}
	
	@Override
	public void visitClass(ClassTree tree) {
		
		System.out.println(tree.superClass());
		
	    String superClassName = null;
	    TypeTree tt = tree.superClass();
	    if(tt!=null) {
	    	superClassName = tree.superClass().symbolType().fullyQualifiedName();
	    }

	    System.out.println(superClassName);
	    
	    // Check if superClass avoid
	    if (superClassName!=null && (superClassName.contains("HttpServlet") || superClassName.contains("GenericServlet"))) {
	      System.out.println("ZAS");
          context.reportIssue(this, tree, "No están permitidos los servlets");
	    }
		
		super.visitClass(tree);
	}
	
	

}
