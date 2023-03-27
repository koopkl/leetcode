use std::fmt::format;

pub struct Solution {

}

impl Solution {
    pub fn multiply(num1: String, num2: String) -> String{
        let mut res = "0".to_string();
        let mut count:usize = 0;

        if let Ok(x) = num1.trim_start_matches("0").to_string().parse::<i128>(){
            if let Ok(y) = num2.trim_start_matches("0").to_string().parse::<i128>() {
                if let Some(res) = x.checked_mul(y) {
                    return res.to_string();
                }
            }
        }

        num2.chars().rev().for_each(|x| {
            res = Self::add_one(res.clone(), format!("{}{}",Self::mul_one(num1.clone(), x.to_string().parse::<i32>().unwrap()), "0".to_string().repeat(count)));
            count += 1;
            // println!("mult: {res}");
        });
        let res = res.trim_start_matches("0").to_string();
        if res.len() == 0 {
            return "0".to_string();
        } else {
            res
        }
    }

    pub fn mul_one(num1: String, one: i32) -> String{
        let mut res = "0".to_string();
        let mut count: usize = 0;
        num1.chars().rev().for_each(|x| {
            res = Self::add_one(res.clone(), format!("{}{}", (x.to_string().parse::<i32>().unwrap() * one).to_string(), "0".to_string().repeat(count)));
            count += 1;
            // println!("add: {res}");
        });

        res
    }

    pub fn add_one(num1: String, num2: String) -> String{
        // println!("{num1}, {num2}");
        // println!("{}, {}", num1.len(), num2.len());
        let mut i = 0;
        let mut add = 0;
        let reverse_num1 = num1.chars().collect::<Vec<char>>();
        let reverse_num2 = num2.chars().collect::<Vec<char>>();
        let mut res = "".to_string();
        let len1 = num1.len();
        let len2 = num2.len();
        while i < len1 || i < len2 {
            let mut x = 0;
            let mut y = 0;
            if i < num1.len() {
                x = reverse_num1[len1- i - 1].to_string().parse::<i32>().unwrap();
            }
            if i < num2.len() {
                y = reverse_num2[len2 - i - 1].to_string().parse::<i32>().unwrap();
            }
            // println!("{x}, {y}, {add}");
            res = format!("{}{}", ((x + y + add) % 10), res);
            add = (x + y + add) / 10;
            i += 1;
        }
        format!("{}{}", add, res)
    }
}

// faster

impl Solution {
    pub fn multiply1(num1: String, num2: String) -> String {
        let mut res: Vec<i32> = vec![];
        let mut num1: Vec<_> = num1.chars().rev().map(|i| (i as i32 - '0' as i32)).collect();
        let mut num2: Vec<_> = num2.chars().rev().map(|i| (i as i32 - '0' as i32)).collect();
        for i in 0..num1.len() {
            for j in 0..num2.len() {
                let v = num1[i] * num2[j];
                if v > 0 {
                    let id = i + j;
                    if id >= res.len() {
                        res.resize(id + 1, 0);
                    }
                    res[id] += v;
                }
            }
        }

        // format
        let mut i = 0;
        while i < res.len() {
            if res[i] > 9 {
                if i + 1 >= res.len() {
                    res.resize(i + 2, 0);
                }
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
            i += 1;
        }
        if res.len() == 0 {
            res.push(0);
        }
        res.iter().rev().map(|i| ('0' as i32 + *i) as u8 as char).collect()
    }
}