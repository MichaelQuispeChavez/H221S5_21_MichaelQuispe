import { TestBed } from '@angular/core/testing';

import { IpQueryService } from './ip-query.service';

describe('IpQueryService', () => {
  let service: IpQueryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IpQueryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
