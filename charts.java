Creating-Charts

import java.io.File; import java.io.FileNotFoundException; import java.util.Arrays; import java.util.Scanner; //second might be needed to fun fully //Author: Sarah Orrico //Date: April 11, 2015 //Class: CS160 //Email: skorrico@rams.colostate.edu

public class P9 implements Interface{

public String[] pieLabels;
public double[] pieChart;
public double[] firstBarChart;
public double[] secondBarChart;
public double[] firstLineGraph;
public double[] secondLineGraph;
public double[] thirdLineGraph; 

@Override
public boolean readFile(String filename) {
	try {
		Scanner scan = new Scanner (new File(filename));
		//read the number of items
		int val1 = scan.nextInt();
		int val2 = scan.nextInt(); 
		int val3 = scan.nextInt();
		//allocate arrays
		pieLabels  = new String[val1];
		pieChart = new double[val1];
		firstBarChart = new double[val2];
		secondBarChart = new double[val2];
		firstLineGraph = new double[val3];
		secondLineGraph = new double[val3];
		thirdLineGraph = new double[val3];
		//read everything for pieChart
		for(int i = 0; i < pieLabels.length; i++)
			pieLabels[i] = scan.next();
		for(int i = 0; i < pieChart.length; i++)
			pieChart[i] = scan.nextDouble();
		for(int i = 0; i < firstBarChart.length; i++)
			firstBarChart[i] = scan.nextDouble();
		for(int i = 0; i < secondBarChart.length; i++)
			secondBarChart[i] = scan.nextDouble();
		for(int i = 0; i < firstLineGraph.length; i++)
			firstLineGraph[i] = scan.nextDouble();
		for(int i = 0; i < secondLineGraph.length; i++)
			secondLineGraph[i] = scan.nextDouble();
		for(int i = 0; i < thirdLineGraph.length; i++)
			thirdLineGraph[i] = scan.nextDouble();
		scan.close();
		System.out.println(Arrays.toString(pieLabels));
		System.out.println(Arrays.toString(pieChart));
		System.out.println(Arrays.toString(firstBarChart));
		System.out.println(Arrays.toString(secondBarChart));
		System.out.println(Arrays.toString(firstLineGraph));
		System.out.println(Arrays.toString(secondLineGraph));
		System.out.println(Arrays.toString(thirdLineGraph));
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}

@Override
public String getTitle(eType type) {
	if(type == eType.PIECHART){
		return "My Pie Chart";
	}
	if(type == eType.BARCHART){
		return "My Bar Chart";
	}
	if(type == eType.LINEGRAPH){
		return "My Line Graph";
	}
	else{
	return null;
	}
}

@Override
public String[] getLabels(eType type) {
	if(type == eType.PIECHART){
		return pieLabels;
	}
	else{
		return null;	
	}
	
}

@Override
public double[] getData(eType type, int series) {
	switch(type){
	case PIECHART:{
		if(series == 0){
			return pieChart;
		}
		else{
			return null;
		}
	}
	case BARCHART:{
		if(series == 0){
			return firstBarChart;
		}
		else if(series == 1){
			return secondBarChart;
		}
		else{
			return null;
		}
	}
	case LINEGRAPH:{
		if(series == 0){
			return firstLineGraph;
		}
		else if(series == 1){
			return secondLineGraph;
		}
		else if(series == 2){
			return thirdLineGraph;
		}
		else{
			return null;
		}
		
	}
	default:
			return null;
	}
}
}
