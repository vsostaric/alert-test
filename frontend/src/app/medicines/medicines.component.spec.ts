import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {MedicinesComponent} from './medicines.component';

describe('MedicinesComponent', () => {
  let component: MedicinesComponent;
  let fixture: ComponentFixture<MedicinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [MedicinesComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MedicinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
