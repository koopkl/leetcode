use std::collections::HashMap;

pub struct Solution {

}

impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let mut res = 0;
        let replace = s.replace("IV", "a")
            .replace("IX", "b")
            .replace("XL", "c")
            .replace("XC", "d")
            .replace("CD", "e")
            .replace("CM", "f");
        let mut map = HashMap::new();
        map.insert( "I", 1);
        map.insert( "a", 4);
        map.insert( "V", 5);
        map.insert( "b", 9);
        map.insert( "X", 10);
        map.insert( "c", 40);
        map.insert( "L", 50);
        map.insert( "d", 90);
        map.insert( "C", 100);
        map.insert( "e", 400);
        map.insert( "D", 500);
        map.insert( "f", 900);
        map.insert( "M", 1000);
        replace.chars().for_each(|x| {
            let str = x.to_string();
            res += map.get(str.as_str()).unwrap();
        });
        res
    }

}