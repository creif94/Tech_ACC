class Animal{
    constructor(name, age, kind,){
        this.name = name
        this.kind = kind;
        this.age = age;
        this.awake = false;
    }
    speak(){
        // console.log(this.name)
        if(this.kind === 'pig'){
            console.log('oink')
            return 'oink'
        }else{
            console.log('roar')
            return 'roar'
        }
    }
    sleep(){
        this.awake = false;
    }
    feed(){
        if(this.awake) {
            return 'NOM NOM NOM'
        }else{
            return 'Animal is not awake'
        }
    }
    wakeUp(){
        this.awake = true;
    }
    growUp(){
        this.age+=1;
    }

}

// ***********************************************************************************************************************


class Clock {
    constructor(options = { hours: 0, minutes: 0, seconds: 0 }) {
        // condition ?(if true) expression :(if false) expression
        this._hours = options.hours < 0 || options.hours > 23 ? 0 : options.hours
        this._minutes = options.minutes < 0 || options.minutes > 59 ? 0 : options.minutes
        this._seconds = options.seconds < 0 || options.seconds > 59 ? 0 : options.seconds
        if(this._seconds === undefined){
            this._seconds = 0
        }
        this.suffix = '';
        this.alarms = [];
        this.format = '24-hour format';
    }

    get hours() { return this._hours }
    set hours(newHours) {
        if (newHours < 0 || newHours > 23) return
        this._hours = newHours
    }

    get minutes() { return this._minutes }
    set minutes(newMinutes) {
        if (newMinutes < 0 || newMinutes > 59) return
        this._minutes = newMinutes
    }

    get seconds() { return this._seconds }
    set seconds(newSeconds) {
        if (newSeconds < 0 || newSeconds > 59) return
        this._seconds = newSeconds
    }

    tick() {
        this._seconds++

        if (this._seconds === 60) {
            this._minutes += 1
            this._seconds = 0

            if (this._minutes === 60) {
                this._hours += 1
                this._minutes = 0

                if (this._hours === 24) {
                    this._hours = 0
                    this._minutes = 0
                    this._seconds = 0
                }
            }
        }
        // console.log(this.alarms)
        for(const alarm of this.alarms){
            if(this._hours === alarm.hours  && this._seconds === alarm.seconds){
                console.log("ALARM")
                // this.alarms = this.alarms.filter(e => e !== alarm)
            }else if (this.hours === alarm.hours && !alarm.minutes && !alarm.seconds){
                console.log("ALARM")
            }
        }

        return this
    }

    currentTime() {



        return `${`${this._hours}`.padStart(2, "0")}:${`${this._minutes}`.padStart(2, "0")}:${`${this._seconds}`.padStart(2, "0")}${this.suffix}`
    }
}
class DigitalClock extends Clock{
    constructor(options){
        super(options)
    }
    toggleFormat(){
        if(this.format === '24-hour format'){
            if(this._hours > 12){
                this.suffix = ' PM'
                this._hours -= 12
            }else{
                this.suffix = ' AM'
            }

            this.format = '12-hour format'
        }else{
            if(this._hours<12){
                this._hours += 12;
            }
            this.suffix = ''
            this.format = '24-hour format'
        }


    }
    setAlarm(options = {hours:0, minutes:0, seconds:0}){
        this.alarms.push(options);
    }
}
// ***********************************************************************************************************************









