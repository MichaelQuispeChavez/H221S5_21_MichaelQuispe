import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IpQueryComponent } from './ip-query.component';

describe('IpQueryComponent', () => {
  let component: IpQueryComponent;
  let fixture: ComponentFixture<IpQueryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [IpQueryComponent]
    });
    fixture = TestBed.createComponent(IpQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
