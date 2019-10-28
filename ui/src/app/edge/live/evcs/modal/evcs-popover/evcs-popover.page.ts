import { Component, Input } from '@angular/core';
import { EdgeConfig } from '../../../../../shared/shared';
import { TranslateService } from '@ngx-translate/core';

@Component({
    selector: 'evcs-popover',
    templateUrl: './evcs-popover.page.html'
})
export class EvcsPopoverComponent {

    @Input() isPrioritization: boolean;
    @Input() isCapacity: boolean;
    @Input() controller: EdgeConfig.Component;

    constructor(
        protected translate: TranslateService,
    ) { }

    ngOnInit() {
    }
}