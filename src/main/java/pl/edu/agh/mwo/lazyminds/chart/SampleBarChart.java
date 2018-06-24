package pl.edu.agh.mwo.lazyminds.chart;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

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
public class SampleBarChart  {
 
  public static void main(String[] args) {
 
    SampleBarChart exampleChart = new SampleBarChart();
    CategoryChart chart = exampleChart.getChart();
    new SwingWrapper<CategoryChart>(chart).displayChart();
  }
 
 
  public CategoryChart getChart() {
 //getHashMap
	HashMap<String,Integer> hmap = new HashMap<String,Integer>();
	hmap.put("Projekt1", 43);
	hmap.put("Projekt2", 77);
	hmap.put("Projekt3", 39);
	  
	ArrayList<String> projects = new ArrayList<String>();
	ArrayList<Integer> hours = new ArrayList<Integer>();
	Set keys = hmap.keySet();
	 for (Iterator i = keys.iterator(); i.hasNext(); ) {
	       String key = (String) i.next();
	       int value = (Integer) hmap.get(key);
	       projects.add(key);
	       hours.add(value);
	 }
    // Create Chart
    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
 
    // Customize Chart
    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
    chart.getStyler().setHasAnnotations(true);
 
    // Series
    
    
    chart.addSeries("Wykres 1", projects,hours);
 
    return chart;
  }
}