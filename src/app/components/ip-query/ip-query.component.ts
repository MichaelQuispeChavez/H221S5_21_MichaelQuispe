import { Component, OnInit } from '@angular/core';
import { IpQueryService } from '../../services/ip-query.service';

@Component({
  selector: 'app-ip-query',
  templateUrl: './ip-query.component.html',
  styleUrls: ['./ip-query.component.css']
})
export class IpQueryComponent implements OnInit {
  myIp: any;
  ipDetails: any;
  queryIpResult: any;
  ipToQuery: string = '';

  constructor(private ipQueryService: IpQueryService) { }

  ngOnInit(): void {
    this.getMyIp();
    this.getIpDetails();
  }

  getMyIp(): void {
    this.ipQueryService.getMyIp().subscribe(data => this.myIp = data);
  }

  getIpDetails(): void {
    this.ipQueryService.getIpDetails().subscribe(data => this.ipDetails = data);
  }

  queryIp(): void {
    this.ipQueryService.queryIp(this.ipToQuery).subscribe(data => this.queryIpResult = data);
  }
}
