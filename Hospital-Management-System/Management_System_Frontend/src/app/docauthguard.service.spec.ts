import { TestBed } from '@angular/core/testing';

import { DocauthguardService } from './docauthguard.service';

describe('DocauthguardService', () => {
  let service: DocauthguardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocauthguardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
