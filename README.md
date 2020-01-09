# Attendance Manager

## About

An android application designed to keep track of attendance throughout the semester. This is my first Android application. 

This application was designed keeping in mind the timetable of my college, DJSCE. Timetable is provided and changes with respective batches. Attendance can be marked in 'Mark your attendance' or quickly done with a left swipe on each subject, or can be cancelled with a right swipe. This also provides total overall attendance, subjects and its attendance at a glance.

The timetable is hard-coded into the application hence enabling it to work offline. Attendance is saved in SQLite. 

## Technology Stack

1. Developed using Android (Java)
1. Data stored in SQLite
1. Has dark mode feature that can be enabled from settings

## Build

- Timetable is in `.json` format and  is stored in `app/src/main/assets/timetable.json`

- It consists of an array of JSON objects containing an 
    - `id` - id of object as number
    - `name` - name of subject 
    - `teacher` - name of teacher
    - `day` - day number (from 1-6)
    - `startTime` - start time of lecture as number and 
    - `endTime` - end time of lecture as number

## Developers

> Adnan Hakim
> [github.com/adnanhakim](https://github.com/adnanhakim)


## MIT LICENSE

> Copyright (c) 2018 Adnan Hakim
>
> Permission is hereby granted, free of charge, to any person obtaining a copy
> of this software and associated documentation files (the "Software"), to deal
> in the Software without restriction, including without limitation the rights
> to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
> copies of the Software, and to permit persons to whom the Software is
> furnished to do so, subject to the following conditions:
>
> The above copyright notice and this permission notice shall be included in all
> copies or substantial portions of the Software.
>
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
> FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
> AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
> LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
> OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
> SOFTWARE.
