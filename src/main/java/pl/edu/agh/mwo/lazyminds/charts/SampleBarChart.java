package pl.edu.agh.mwo.lazyminds.charts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;

import pl.edu.agh.mwo.lazyminds.model.Project;
import pl.edu.agh.mwo.lazyminds.model.User;
import pl.edu.agh.mwo.lazyminds.reports.ReportHowManyHoursPerProject;

/**
 * Basic Bar Chart
 * 
 * Demonstrates the following:
 * <ul>
 * <li>Integer categories as List
 * <li>All positive values
 * <li>Single series
 * <li>Place legend at Inside-NW position
 * <li>Bar Chart Annotations
 */
public class SampleBarChart {

	

	
	public void drawChart(HashSet<User> users, int year) {
		
		ReportHowManyHoursPerProject rhmhpp = new ReportHowManyHoursPerProject();
		HashMap<Project, Integer> hmap = rhmhpp.getHashMap(users,year);
		SampleBarChart exampleChart = new SampleBarChart();
		CategoryChart chart = exampleChart.getChart(hmap);
		new SwingWrapper<CategoryChart>(chart).displayChart();
		

		
		
	}

	public CategoryChart getChart(HashMap<Project, Integer> map) {
		// getHashMap
		
	
		

		// hmap.put("Projekt1", 43);
		// hmap.put("Projekt2", 77);
		// hmap.put("Projekt3", 39);

		ArrayList<String> projects = new ArrayList<String>();
		ArrayList<Integer> hours = new ArrayList<Integer>();
		Set keys = map.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			Project key = (Project) i.next();
			int value = (Integer) map.get(key);
			projects.add(key.getName());
			hours.add(value);
		}
		// Create Chart
		CategoryChart chart = new CategoryChartBuilder().width(1600).height(1100).title("Score Histogram")
				.xAxisTitle("Score").yAxisTitle("Number").build();

		// Customize Chart
		// chart.getStyler().setLegendPosition(LegendPosition.LEFT);
		chart.getStyler().setHasAnnotations(true);

		// Series

		chart.addSeries("Wykres", projects, hours);

		return chart;
	}
}