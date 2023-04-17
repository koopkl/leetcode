use std::collections::HashMap;

pub struct Solution {

}

pub struct Info {
    id: String,
    state: String,
    time: i32,
    flag: i32,
}

impl Info {
    pub fn new(id: String, state: String, time: i32, flag: i32) -> Info{
        Info {
            id,
            state,
            time,
            flag
        }
    }
}

impl Solution {
    pub fn exclusive_time(n: i32, logs: Vec<String>) -> Vec<i32> {
        let mut res = vec![0;n as usize];
        let mut stack: Vec<Info>= vec![];
        logs.into_iter().for_each(|log| {
            let split = log.split(":").collect::<Vec<&str>>();
            let id = split[0].to_string();
            let time = split[2].to_string().parse::<i32>().unwrap();
            match split[1] {
                "start" => {
                    let info = Info::new(id,
                                         "start".to_string(),time, 0);
                    stack.push(info);
                },
                "end" => {
                    let top = stack.pop().unwrap();
                    let index = id.parse::<usize>().unwrap();
                    let all_time = time - top.time - top.flag + 1;
                    res[index] += all_time;
                    if stack.len() > 0 {
                        let temp_len = stack.len();
                        stack[temp_len - 1].flag += all_time + top.flag;
                    }
                },
                _ => {}
            }
        });
        res
    }
}