import {NativeDateAdapter} from '@angular/material/core';

export class AppDateAdapter extends NativeDateAdapter {

  private static _to2digit(n: number) {
    return ('00' + n).slice(-2);
  }

  // tslint:disable-next-line:ban-types
  format(date: Date, displayFormat: Object): string {
    if (displayFormat === 'input') {
      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();
      return AppDateAdapter._to2digit(day) + '-' + AppDateAdapter._to2digit(month) + '-' + year;
    } else {
      return date.toDateString();
    }
  }

}
