import {Component, OnInit} from '@angular/core';
import {WorkLogService} from '../../services/work-log.service';
import {ChartDataSets, ChartOptions, ChartType} from 'chart.js';
import {FilterWorkLogStatistic} from '../../../models/entity/FilterWorkLogStatistic';
import {Label} from 'ng2-charts';
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-filter-statistic-worklog-bar-chart',
  templateUrl: './filter-statistic-worklog-bar-chart.component.html',
  styleUrls: ['./filter-statistic-worklog-bar-chart.component.css']
})
export class FilterStatisticWorklogBarChartComponent implements OnInit {

  showTableFlag;
  showChartDiagramFlag;
  filterWorkLogsStatistics: FilterWorkLogStatistic[];
  avgArray: number[] = [];

  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: Label[] = [];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];
  barChartData: ChartDataSets[] = [
    {data: this.avgArray, label: `Temperature`}
  ];

  constructor(private workLogService: WorkLogService) {
  }

  ngOnInit(): void {
    this.workLogService.getFilterWorkLogStatistic().subscribe((workLogsStatistics: FilterWorkLogStatistic[]) => {
      for (const filterWorkLogsStatistic of workLogsStatistics) {
        this.barChartLabels.push(formatDate(filterWorkLogsStatistic.scanDate, 'yyyy-MM-dd HH:mm:ss', 'en_UK', '+0'));
        this.avgArray.push(filterWorkLogsStatistic.avgTemperature);
      }

      this.filterWorkLogsStatistics = workLogsStatistics;
      console.log(this.filterWorkLogsStatistics);
    });
  }

  showTable() {
    this.showTableFlag = !this.showTableFlag;
  }

  showDiagram() {
    this.showChartDiagramFlag = !this.showChartDiagramFlag;
  }

}
